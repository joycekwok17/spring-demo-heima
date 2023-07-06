package org.example.factory;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/6/23
 */
public class BeanFactory {
    private static Properties props; //

    private static Map<String, Object> beans; // a container holding all class instances

    static { // will be executed when class loading
        try {
            props = new Properties();
            InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(inputStream);

            beans = new HashMap<String,Object>();
            Enumeration keys = props.keys();
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
                Object value = Class.forName(beanPath).newInstance(); //
                beans.put(key, value);
            }
        } catch (Exception e) {
            throw new ExceptionInInitializerError("initialize properties failed!");
        }
    }

    public static Object getBean(String beanName) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
//        Object bean = null;
//        String beanPath = props.getProperty(beanName);
//        bean = Class.forName(beanPath).newInstance(); //
        return beans.get(beanName);
//        return bean;
    }
}
