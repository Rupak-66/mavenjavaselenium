package org.example;

public class Singletonexample {
    private static Singletonexample singletonInstance = null;


    private Singletonexample() {

    }

    public static Singletonexample getSingletonInstance() {
        if (singletonInstance == null) {
            singletonInstance = new Singletonexample();
        }
        return singletonInstance;
    }


}
