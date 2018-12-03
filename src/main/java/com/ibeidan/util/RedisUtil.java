package com.ibeidan.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 操作redis方法
 * Created by lee on 2017/7/6 0006.
 */
@Component
public class RedisUtil {

    private Logger log = LoggerFactory.getLogger(RedisUtil.class);

    public static RedisUtil redisUtil = null;

    @Autowired
    protected RedisTemplate redisTemplate;

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }
    @PostConstruct
    public void init() {
        redisUtil = this;
    }


    public long setPipeLine(){
        long start = System.currentTimeMillis();
         List  objList = redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                for (int i =0;i<500000;i++){
                    byte[] rowKey = redisTemplate.getKeySerializer().serialize("a"+i);
                    byte[] rawValue = redisTemplate.getKeySerializer().serialize(i+"");

                    connection.set(rowKey,rawValue);
                }
                return null;
            }
        });
        long end = System.currentTimeMillis()-start;
        log.info("setPipeLine,执行时间{}毫秒,成功设置{}条记录。",end,objList.size());
        return  end;
    }

    /**
     * 设置过期时间戳 精确到毫秒
     * @param dateStr
     * @return
     */
    public long exPireAtPipeLine(String dateStr){
        long start = System.currentTimeMillis();
        redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.openPipeline();
                for (int i =0;i<3;i++){
                    byte[] rowKey = redisTemplate.getKeySerializer().serialize("a"+i);
                    connection.pExpireAt(rowKey,DateUtils.getDateStrToLong(dateStr));
                   // connection.expireAt(rowKey,DateUtils.getDateStrToSeconds(dateStr));
                }
                return null;
            }
        });
        long end = System.currentTimeMillis()-start;
        log.info("exPireAtPipeLine,执行时间{}毫秒,成功设置{}条记录。",end);
        return  end;
    }
    public void setKey(){
        long start = System.currentTimeMillis();

        for (int i =0;i<100000;i++) {
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            redis.set("b"+i, i+"");
        }
        long end = System.currentTimeMillis()-start;
        log.info("setKey,执行时间{}毫秒,成功设置{}条记录。",end,100000);
    }
    /**
     * 将字符串值 value 关联到 key 。
     * 如果 key 已经持有其他值， SET 就覆写旧值，无视类型。
     * @param key redis key
     * @param value 写入的值
     */
    public void set(String key, String value) {
        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)){
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            redis.set(key,value);
        }
    }

    /**
     * 设置key的过期日期
     *
     * @param key  redis key
     * @param value 写入的值
     * @param tempTime 过期时间
     * @param timeUnit 单位
     */
    public void setex(String key, String value,long tempTime,TimeUnit timeUnit) {
        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)){
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            redis.set(key, value, tempTime, timeUnit);
        }
    }
    
    /**
     * 设置key value  如果有则不处理
     * @author: lee
     * @createTime: 2017年8月22日 下午1:41:31  
     * @history:  
     * @param key
     * @param value
     * @param tempTime
     * @param timeUnit void
     */
    public boolean setnx(String key, String value,long tempTime,TimeUnit timeUnit) {
        if(StringUtils.isNotBlank(key) && StringUtils.isNotBlank(value)){
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            boolean result = redis.setIfAbsent(key, value);
            if(result){
            	redisTemplate.expire(key, tempTime, timeUnit);
            }
            return result;
        }
        return false;
    }

    /**
     * 设置当前过期日期
     * @param key key
     * @param tempTime 过期时间
     * @param timeUnit 单位
     */
    public void expire(String key, long tempTime,TimeUnit timeUnit) {

        if(StringUtils.isNotBlank(key)){
            redisTemplate.expire(key, tempTime, timeUnit);
        }
    }

    /**
     * 获取redis key的值
     * @param key key
     * @return value
     */
    public String get(String key) {
        String value = null;
        if(StringUtils.isNotBlank(key)){
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            value = redis.get(key);
        }
        return value;
    }

    /**
     * 删除对应的key
     * @param key key
     */
    public void delete(String key) {
        if(StringUtils.isNotBlank(key)){
            redisTemplate.delete(key);
        }
    }

    /**
     * 每次对应增加 1
     * @param key key
     * @return 增长后的值
     */
    public Long incr(String key) {
        Long val = null;
        if(StringUtils.isNotBlank(key)){
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            val = redis.increment(key, 1L);
        }
        return val;
    }

    /**
     * 每次对应减去 1
     * @param key key
     * @return 减去后的值
     */
    public Long decr(String key) {
        Long val = null;
        if(StringUtils.isNotBlank(key)){
            ValueOperations<String, String> redis = redisTemplate.opsForValue();
            val = redis.increment(key, -1L);
        }
        return val;
    }

    /**
     * 缓存中是否包含redis key
     * @param key  kye
     * @return true 包含  false 不包含
     */
    public Boolean exists(String key){
        if(StringUtils.isBlank(key)){
            return false;
        }
        return redisTemplate.hasKey(key);
    }

    /**
     * 缓存MAP中是否包含redis key
     * @param mapKey  缓存map的redis kye
     * @param filed  map key
     * @return true 包含  false 不包含
     */
    public Boolean hexists(String mapKey, String filed){
        if(StringUtils.isBlank(mapKey) || StringUtils.isBlank(filed) ){
            return false;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        return hashOps.hasKey(mapKey, filed);
    }

    /**
     * 返回哈希表 key 中给定域 field 的值。
     * @param key hashkey
     * @param filed filed的key
     * @return value
     */
    public String hget(String key, String filed){
        if(StringUtils.isBlank(key) || StringUtils.isBlank(filed)){
            return null;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        return hashOps.get(key, filed);
    }

    /**
     * 将哈希表 key 中的域 field 的值设为 value 。
     * 如果 key 不存在，一个新的哈希表被创建并进行 HSET 操作。
     * 如果域 field 已经存在于哈希表中，旧值将被覆盖。
     * @param key key
     * @param filed hashkey
     * @param value hashKey 的value
     */
    public void hset(String key, String filed ,String value){
        if(StringUtils.isBlank(key) || StringUtils.isBlank(filed)
                || StringUtils.isBlank(value)){
            return;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        hashOps.put(key, filed, value);
    }

    /**
     * 删除hash 中的key
     * @param key key
     * @param filed hashkey
     */
    public void hdel(String key, String... filed){
        if(StringUtils.isBlank(key) || filed == null){
            return;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        hashOps.delete(key, filed);
    }

    /**
     * @desc: 根据key获取redis map的所有数据
     * @author: lee
     * @createTime: 2017/8/23 11:06
     * @history:
     * @version: v1.0
     */
    public Map<String, String> hgetAll(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        return hashOps.entries(key);
    }

    /**
     * 获取hash表中对应的key
     * @param key 缓存key
     * @return keys keys的所有值
     */
    public Set<String> hkeys(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        Set<String> keys = hashOps.keys(key);
        return keys;
    }
    /**
     * 获取hash表中对应的value
     * @param key 缓存key
     * @return keys value的所有值
     */
    public List<String> hvals(String key){
        if(StringUtils.isBlank(key)){
            return null;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();

        List<String> values = hashOps.values(key);
        return values;
    }

    /**
     * 压栈list
     * @author: lee
     * @createTime: 2017年7月20日 下午7:22:35  
     * @history:  
     * @param key 主键
     * @param values 值
     * @return Long
     */
    public Long lpush(String key, String... values) {
    	Long l = null;
		if (StringUtils.isBlank(key) || null == values) {
			return 0L;
		}
    	ListOperations<String, String> listOps= redisTemplate.opsForList();
    	l = listOps.leftPushAll(key, values);
    	return l;
    }
    
    /**
     * 压栈list
     * @author: lee
     * @createTime: 2017年7月20日 下午7:22:35  
     * @history:  
     * @param key 主键
     * @param values 值
     * @return Long
     */
    public Long lpush(String key, List<String> values) {
    	Long l = null;
		if (StringUtils.isBlank(key) || null == values) {
			return 0L;
		}
    	ListOperations<String, String> listOps= redisTemplate.opsForList();
    	l = listOps.leftPushAll(key, values);
    	return l;
    }
    
    /**
	 * 范围检索 list内元素
     * @author: lee
     * @createTime: 2017年7月20日 下午7:22:08  
     * @history:  
     * @param key 主键
     * @param start 开始下标
     * @param end 结束下标
     * @return List<String>
     */
    public List<String> range(String key, long start, long end) {
		ListOperations<String, String> listOps = redisTemplate.opsForList();
		if (listOps.size(key) == 0) {
			return new ArrayList<>();
		}
		return redisTemplate.opsForList().range(key, start, end);
	}
    /**
     * 将一个或多个 member 元素加入到集合 key 当中，已经存在于集合的 member 元素将被忽略。
     * 假如 key 不存在，则创建一个只包含 member 元素作成员的集合。
     * 当 key 不是集合类型时，返回一个错误。
     * @param key redisKey
     * @param member value
     * @return num
     */
    public Long sadd(String key, String... member) {
        SetOperations<String, String> setValue = redisTemplate.opsForSet();
        Long num = setValue.add(key, member);
        return num;
    }
    /**
     * 放置map<String,String> 数据
     * @author: lee
     * @createTime: 2017年7月25日 下午3:54:11  
     * @history:  
     * @param key
     * @return String
     */
    public void hsetAll(String key, Map<String,String> map){
    	if(StringUtils.isBlank(key)){
            return ;
        }
        if(map == null || map.size() == 0){
            return ;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        hashOps.putAll(key, map);
    }
    
    /**
     * 获取hash field的数量
     * @author: lee
     * @createTime: 2017年7月25日 下午3:54:11  
     * @history:  
     * @param key
     * @return int
     */
    public Long hlen(String key){
    	if(StringUtils.isBlank(key)){
            return 0L;
        }
        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        return  hashOps.size(key);
    }
}
