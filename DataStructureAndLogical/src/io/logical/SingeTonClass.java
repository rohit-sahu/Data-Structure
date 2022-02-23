package io.logical;

public class SingeTonClass {

    private static SingeTonClass singeTonClass;

    private SingeTonClass() {
    }

    /*static {
        if (singeTonClass == null) {
            singeTonClass = new SingeTonClass();
        }
    }*/

    public synchronized static SingeTonClass getSingeTonClass() {
        if (singeTonClass == null) {
            synchronized (SingeTonClass.class) {
                singeTonClass = new SingeTonClass();
            }
        }
        return singeTonClass;
    }
}
