package com.asuco.type1;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 饿汉式（静态常量）
 */
public class SingletonTest01 {
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
    //1. 构造器私有化
    private Singleton() {

    }

    //2. 本类内部创建一个对象实例
    private final static Singleton instance = new Singleton();
    //在类装载是就完成了实例化，可避免多线程同步问题，可能会造成内存的浪费

    //3. 对外提供一个公有的静态方法，返回实例对象
    public static Singleton getInstance() {
        return instance;
    }
}
