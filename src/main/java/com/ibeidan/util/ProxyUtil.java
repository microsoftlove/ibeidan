package com.ibeidan.util;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.charset.Charset;

/**
 * @author lee
 * @DATE 2019/5/31 10:31
 */
public class ProxyUtil {

    /**
     * 基于聚合的动态代理
     * 1、得到一个代理对象的java文件
     * 2、编译成为一个class文件
     * 3、classLoader加载磁盘上的java文件
     * 4、通过反射得到对象
     * 5、返回代理对象
     *
     **/

    public static Object newProxyInstance(Object target) throws Exception {

        String content = "";

        Class targetInfo = target.getClass().getInterfaces()[0];//获得目标对象的第一个实现信息

        String packerContent = "package com.ibeidan;" ;

        String targetInfoName = targetInfo.getSimpleName();

        String importContent = "import "+targetInfo.getName()+" ;";

        String firstContent = "public class $Proxy implements "+targetInfoName +"{";

        String filedContent = "private "+targetInfoName +" target;";

        String constructorContent = "public $Proxy("+targetInfoName+" target){"+
                "this.target = target;"+
                "}";
        Method[] methods = targetInfo.getDeclaredMethods();

        String methodsContent = "";

        for (Method method : methods){
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();

             Class<?>[] parameterTypes = method.getParameterTypes();
             String argsContent = "" ;
             String paramesContent="";

            int i = 0;
             for (Class paramType : parameterTypes){
                 String simpleName = paramType.getSimpleName();
                 argsContent += simpleName + " p"+i+",";
                 paramesContent +=  " p"+i+",";

                 i ++;
             }
            if (argsContent.length()>0){
                argsContent = argsContent.substring(0,argsContent.lastIndexOf(",")-1);
                paramesContent = paramesContent.substring(0,paramesContent.lastIndexOf(",")-1);
            }
            methodsContent += "public " +returnTypeName+" "+methodName+"("+argsContent+"){"+
                    "System.out.println(\"log proxy start...\");"+
            "target."+methodName+"("+paramesContent+");}";
        }
        content+= packerContent+importContent+firstContent+filedContent+constructorContent+methodsContent+"}";

        String path = "/Users/lee/Downloads/$Proxy.java";

        byte[] classFile = content.getBytes();
        try{
            File file = new File(path);
            if (file.exists()){
                file.delete();
            }
            FileOutputStream fos = new FileOutputStream(path);
            fos.write(classFile);
            fos.flush();
            System.out.println("代理类class文件写入成功");
        } catch (Exception e) {
            System.out.println("写文件错误");
        }

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,
                Charset.defaultCharset());
        Iterable units = fileManager.getJavaFileObjects(path);
        JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
        t.call();
        fileManager.close();

        URL url = new URL("file:/Users/lee/javaworkspace/ibeidan/target/test-classes/");
        System.out.println(url+"  ");

        URL[] urls = new URL[]{url};
        URLClassLoader urlClassLoader = new URLClassLoader(urls);
        Class clazz = urlClassLoader.loadClass("com.ibeidan.$Proxy");
         Constructor constructor = clazz.getConstructor(targetInfo);
         Object o = constructor.newInstance(target);
        return o;
    }




}
