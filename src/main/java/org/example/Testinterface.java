package org.example;

public class Testinterface {
    public static void main(String[] args) {
        Payment p = new CashPayment();
        p.test();

        Payment p1 = new CreditPayment();


    }
}

interface Payment {
    int oounter = 1;
     void pay();

     default void test(){
         System.out.println("Payment1");
     }
}

interface Payment2 {
    void pay();

    default void test(){
        System.out.println("Payment2");
    }
}


class CashPayment implements Payment, Payment2{

    @Override
    public void pay() {
        System.out.println("PAyment from CashPayment class");
    }

    @Override
    public void test() {
        Payment2.super.test();
    }
}

class CreditPayment implements Payment {
    // method overriding
    @Override
    public void pay() {
        System.out.println("This is CreditPayment payment");
    }
}
