package com.starrk.design.delegator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * 代理处理器
 */
public class Delegator implements InvocationHandler {

    /**
     * 被代理对象
     */
    protected Object target;

    /**
     * 将需要被代理对象通过构造传递给代理
     */
    public Delegator(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {

        // 通过代理扩展get方法
        if ("get".equals(method.getName())) {
            System.out.println("执行委托类方法");
        }
        return method.invoke(target, args);
    }

    // 动态代理类生成器
    public static class DynamicDelegator {

        public Object getProxy(Object instance, InvocationHandler delegator) {

            // 获取被代理类的ClassLoader
            ClassLoader classLoader = instance.getClass().getClassLoader();

            // 动态产生一个代理者
            Class<?>[] cls = new Class[]{Map.class};
            return Proxy.newProxyInstance(classLoader, cls, delegator);
        }
    }

    public static void main(String[] args) {

        //被代理的类
        Map<String, String> map = new HashMap<String, String>();

        // 创建代理处理对象实例
        InvocationHandler delegator = new Delegator(map);
        DynamicDelegator dynamicDelegator = new DynamicDelegator();

        // 动态获取代理对象
        Map<String, String> proxyMap = (Map<String, String>) dynamicDelegator.getProxy(map, delegator);

//        // 获取被代理类的ClassLoader
//        ClassLoader classLoader = map.getClass().getClassLoader();
//
//        // 动态产生一个代理者
//        Class<?>[] cls = new Class[]{Map.class};
//        Map<String, String> proxyMap = (Map<String, String>) Proxy.newProxyInstance(classLoader, cls, delegator);
        proxyMap.get("111");
    }
}
