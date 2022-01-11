package com.asuco.type8;

/**
 * @Author Mr_Asuco
 * @Version 1.0
 * @Description 枚举（推荐使用）
 */
public class SingletonTest08 {
    public static void main(String[] args) {
        //测试
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

        instance.getInstance();
    }
}

enum Singleton {
    INSTANCE; //属性
    public void getInstance() {
        System.out.println("Asuco");
    }
}