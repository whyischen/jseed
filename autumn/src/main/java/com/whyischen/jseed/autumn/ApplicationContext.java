package com.whyischen.jseed.autumn;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

public class ApplicationContext {

    public static final String SCOPE_SINGLETON = "singleton";

    /**
     * 配置文件类
     */
    private Class<?> configClass;

    /**
     * 单例池
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    /**
     * 1. 获取 Bean 的类扫描路径
     * 2. 递归加载类，并判断是否为 Bean
     *
     * @param configClass 配置文件类
     */
    public ApplicationContext(Class<?> configClass) {
        this.configClass = configClass;

        // 扫描 Bean
        scan(configClass);

        beanDefinitionMap.forEach((beanName, beanDefinition) -> {
            if (SCOPE_SINGLETON.equals(beanDefinition.getScope())) {
                Object bean = createBean(beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        });

    }

    /**
     * 根据配置文件扫描 Bean
     *
     * @param configClass 配置类
     */
    private void scan(Class<?> configClass) {
        ComponentScan componentScanAnnotation = configClass.getDeclaredAnnotation(ComponentScan.class);
        String sourcePath = componentScanAnnotation.value();
        sourcePath = sourcePath.replace(".", "/");

        // 类加载器
        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(sourcePath);

        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String filePath = f.getAbsolutePath();
                String fileName = filePath.substring(filePath.indexOf("com"), filePath.indexOf(".class"));
                fileName = fileName.replace("/", ".");

                try {
                    Class<?> clazz = classLoader.loadClass(fileName);
                    if (!clazz.isAnnotationPresent(Component.class)) {
                        continue;
                    }
                    // 有@Component注解
                    Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);
                    String beanName = componentAnnotation.name();

                    BeanDefinition beanDefinition = new BeanDefinition();
                    beanDefinition.setClazz(clazz);

                    Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                    if (scopeAnnotation != null) {
                        beanDefinition.setScope(scopeAnnotation.value());
                    } else {
                        beanDefinition.setScope(SCOPE_SINGLETON);
                    }

                    beanDefinitionMap.put(beanName, beanDefinition);


                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) {

        Class<?> clazz = beanDefinition.getClazz();

        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }


    public Object getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            return null;
        }

        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (SCOPE_SINGLETON.equals(beanDefinition.getScope())) {
            return singletonObjects.get(beanName);
        }

        // 创建 Bean
        return createBean(beanDefinition);
    }


}
