package com.asuco.type6;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 双重检查（推荐使用）
 */
public class SingletonTest06 {
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
    //共享的变量一旦有修改值就会刷到储存里面去，在一定程度上达到同步的效果
    private static volatile Singleton instance;

    private Singleton() {
    }

    //加入双重检查代码，解决线程安全问题，同时解决懒加载问题，也保证了效率
    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        // 解析：
        // 若此时有A、B两个线程。当A创建实例时，就算两个
        // 线程同时通过第一个判断条件，也只有一个线程能创
        // 建实例。以后再有线程，第一个判断条件都无法满足
        return instance;
    }
}