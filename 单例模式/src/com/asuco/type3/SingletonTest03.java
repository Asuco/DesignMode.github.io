package com.asuco.type3;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 懒汉式（线程不安全）
 */
public class SingletonTest03 {
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
    private static Singleton instance;

    private Singleton() {}

    //提供一个静态的公有方法，当使用到该方法时，才去创建instance
    //即懒汉式
    public static Singleton getInstance() {
        //此处条件判断已出现线程安全问题
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
