package com.whyischen.jseed.autumn;

import java.io.File;
import java.net.URL;

public class ApplicationContext {

    private Class<?> configClass;

//    private ConcurrentHashMap<String, Object>

    /**
     * 1. 获取Bean的类扫描路径
     * 2. 递归加载类，并判断是否为Bean
     *
     * @param configClass 配置文件类
     */
    public ApplicationContext(Class<?> configClass) {
        this.configClass = configClass;

        ComponentScan componentScanAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        String sourcePath = componentScanAnnotation.value();
        System.out.println("sourcePath: " + sourcePath);

        // 类加载器
        // Bootstrap    -> jre/lib
        // Ext          -> jre/ext/lib
        // App          -> classpath
        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource("com/whyischen/jseed/springlearn/service");
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
//                classLoader.
                System.out.println(f);
            }
        }
    }

    public Object getBean(String beanName) {
        return null;
    }


}
