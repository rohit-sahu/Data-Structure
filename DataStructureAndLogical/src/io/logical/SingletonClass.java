package io.logical;
public class SingletonClass {
    private static SingletonClass instance;
    private SingletonClass() {
        super();
    }
    /*static {
        if (instance == null) {
            instance = new SingletonClass();
        }
    }*/
    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                instance = new SingletonClass();
            }
        }
        return instance;
    }
}
