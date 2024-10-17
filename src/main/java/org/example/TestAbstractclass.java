package org.example;

public class TestAbstractclass {
    public static void main(String[] args) {

    }
}

abstract class Animal{

    abstract void birth();

    public void hunting(){
        System.out.println("Anima hunts");
    }
}

class Tiger extends Animal {

    @Override
    void birth() {
        System.out.println("Tiger is born");
    }
}
