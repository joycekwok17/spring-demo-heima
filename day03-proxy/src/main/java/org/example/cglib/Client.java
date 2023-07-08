package org.example.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Dynamic Proxy Demo
 * CGLIB Proxy Demo (Dynamic Proxy) - No Interface Required (unlike JDK Proxy) - No need to implement InvocationHandler
 * @author Xuanchi Guo
 * @project Spring-demo
 * @created 7/8/23
 */
public class Client {
    public static void main(String[] args) {
        final Producer producer = new Producer();
//        producer.saleProduct(10000f);
//        producer.afterService(10000f);

        Producer cglibProducer = (Producer) Enhancer.create(producer.getClass(),
                new MethodInterceptor() {
                    /**
                     * 执行被代理对象的任何方法都会经过该方法
                     * @param o 代理对象的引用
                     * @param method 当前执行的方法
                     * @param args 当前执行方法所需的参数
                     * @param methodProxy 当前执行方法的代理对象
                     * @return
                     * @throws Throwable
                     */
                    @Override
                    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        //                 提供增强的代码
                        Object returnValue = null;
                        Float money = (Float) args[0];
                        // 判断当前方法是不是销售
                        if ("saleProduct".equals(method.getName())) {
                            returnValue = method.invoke(producer, money * 0.8f);
                        }
                        return returnValue;
                    }
                });
        cglibProducer.saleProduct(12000f);


//        // 代理
//        IProducer proxyProducer = (IProducer) Proxy.newProxyInstance(producer.getClass().getClassLoader(),
//                producer.getClass().getInterfaces(),
//                new InvocationHandler() {
//                    /**
//                     * 执行被代理对象的任何方法都会经过该方法
//                     * @param o 代理对象的引用
//                     * @param method 当前执行的方法
//                     * @param args 当前执行方法所需的参数
//                     * @return 和被代理对象方法有相同的返回值
//                     * @throws Throwable
//                     */
//                    @Override
//                    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
//                        // 提供增强的代码
//                        Object returnValue = null;
//                        Float money = (Float) args[0];
//                        // 判断当前方法是不是销售
//                        if ("saleProduct".equals(method.getName())) {
//                            return method.invoke(producer, money * 0.8f);
//                        }
//                        return returnValue;
//                    }
//                }
//        );
//        proxyProducer.saleProduct(10000f);
    }
}
