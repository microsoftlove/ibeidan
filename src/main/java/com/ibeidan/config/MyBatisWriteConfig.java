package com.ibeidan.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * 
* @ClassName: MyBatisConfig  
* @author
* @date 2017年4月18日  
*
 */
@Configuration
@ComponentScan
@MapperScan(basePackages = "com.ibeidan.web.mapper.write", sqlSessionFactoryRef = "writeSqlSessionFactory") //扫描mappper
public class MyBatisWriteConfig {
	@Value("${spring.datasource.write.type}")
    private Class<? extends DataSource> dataSourceType;  
  
	@Value("${spring.datasource.write.username}")
	String userName;
	@Value("${spring.datasource.write.password}")
	String passWord;
	@Value("${spring.datasource.write.url}")
	String url;
	@Value("${spring.datasource.write.driver-class-name}")
	String driverClassName;

    @Bean(name="writeDataSource")
    @Primary
    public DataSource druidDataSource() {  
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl(url);  
        druidDataSource.setUsername(userName);//用户名  
        druidDataSource.setPassword(passWord);//密码  
        druidDataSource.setDriverClassName(driverClassName);  
        druidDataSource.setInitialSize(5);  
        druidDataSource.setMinIdle(5);  
        druidDataSource.setMaxActive(20);  
        druidDataSource.setMaxWait(60000);  
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        druidDataSource.setValidationQuery("SELECT 1"); 
        druidDataSource.setTestOnBorrow(false);  
        druidDataSource.setTestWhileIdle(true); 
        druidDataSource.setTestOnReturn(false);
        druidDataSource.setPoolPreparedStatements(true);
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(20);
        //期把监控数据输出到日志中
        druidDataSource.setTimeBetweenLogStatsMillis(300000);
        //2017-04-28
        WallFilter wallFilter=null;
        List<Filter> list=getList(wallFilter);
        druidDataSource.setProxyFilters(list);
        return druidDataSource;  
    }  
    //2017-04-28
    @Bean(name="wall-config")
    public WallConfig wallConfig(){
    	WallConfig config=new WallConfig();
    	config.setMultiStatementAllow(true);
    	return config;
    }
    //2017-04-28
    @Bean(name="wall-filter")
    public WallFilter wallFilter(@Qualifier("wall-config")WallConfig wallConfig){
    	WallFilter wallFilter=new WallFilter();
    	wallFilter.setConfig(wallConfig);
    	return wallFilter;
    }
    //2017-04-28
    @Bean
    List<Filter> getList(@Qualifier("wall-filter")WallFilter wallFilter){
    	List<Filter> list=new ArrayList<Filter>();
        list.add(wallFilter);
        return list;
    }
    
	@Bean(name = "writeSqlSessionFactory")
	@Primary
	public SqlSessionFactory writeSqlSessionFactory(@Qualifier("writeDataSource") DataSource druidDataSource) throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(druidDataSource);
//		sqlSessionFactoryBean.setTypeAliasesPackage("com.xebest.web.model");
		
		//分页插件
        PageHelper pageHelper = new PageHelper();
        Properties properties = new Properties();
        //设置为true时，如果pageSize=0或者RowBounds.limit = 0就会查询出全部的结果
        properties.setProperty("pageSizeZero", "true");
        properties.setProperty("reasonable", "false");
        properties.setProperty("supportMethodsArguments", "false");
        properties.setProperty("returnPageInfo", "check");
        properties.setProperty("params", "count=countSql");
        pageHelper.setProperties(properties);

        //添加插件
        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});	
		
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mybatis/write/*.xml"));
		sqlSessionFactoryBean.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
		return sqlSessionFactoryBean.getObject();
	}

	/**
	 * 配置事务管理器
	 */
	@Bean(name = "writeTransactionManager")
	@Primary
	public DataSourceTransactionManager transactionManager(
			@Qualifier("writeDataSource") DataSource dataSource) throws Exception {
		return new DataSourceTransactionManager(dataSource);
	}
}