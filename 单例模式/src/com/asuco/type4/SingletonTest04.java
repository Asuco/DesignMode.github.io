package com.asuco.type4;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 懒汉式（线程安全，同步方法）
 */
public class SingletonTest04 {
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

    //提供一个静态的公有方法，加入同步处理的代码，解决线程安全问题
    //synchronized：当有一个线程在执行getInstance(),其他线程只能排队等待
    //效率太低，实际开发中不推荐
    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }

        return instance;
    }
}
