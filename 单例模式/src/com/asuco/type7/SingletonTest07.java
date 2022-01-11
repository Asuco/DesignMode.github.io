package com.asuco.type7;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 静态内部类（推荐使用）
 */
public class SingletonTest07 {
    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}

class Singleton {

    //构造器私有化
    private Singleton() {
    }

    //写一个静态内部类，该类中有一个静态属性Singleton
    //1. 当Singleton类装载时，不会引起SingletonInstance内部类的装载，即懒加载
    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    //提供一个静态的共有方法,直接返回SingletonInstance.INSTANCE
    //2. 当我们调用getInstance()时，会去获取SingletonInstance.INSTANCE
    // 从而导致SingletonInstance内部类的装载，而JVM在装载类时是线程安全的
    public static Singleton getInstance() {

        return SingletonInstance.INSTANCE;
    }
}