package com.asuco.type5;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 懒汉式（线程不安全，同步代码块）,实际开发中不能使用
 */
public class SingletonTest05 {
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

    private Singleton() {
    }

    //synchronized：当有一个线程在执行getInstance(),其他线程只能排队等待
    public static Singleton getInstance() {
        //此处条件判断已出现线程安全问题
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }

        return instance;
    }
}