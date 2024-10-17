package org.example;

public class Testtwo {
    public static void main(String[] args) {
        int purchaseAmount = 12;

        if(purchaseAmount >= 20){
            purchaseAmount -= 2;
        }

        else if (purchaseAmount >= 10 & purchaseAmount < 20){
            purchaseAmount -= 1;
        }

        else{
            purchaseAmount -= 0;
        }


        System.out.println(purchaseAmount);

    }
}
