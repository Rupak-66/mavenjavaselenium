package org.example;

public class Testclass {
    public static void main(String[] args) {
        int i = 4;
        Testclass cal = new Testclass();
        System.out.println(cal.calculator(4,5,"*"));
    }



    public int calculator(int a, int b, String operator){
        int result = 0;
        if(operator.equals("+")){
            result= a+b;
        }
        else if(operator.equals("-")){
            result= a-b;
        }
        else if(operator.equals("*")){
            result= a*b;
        }
        else if(operator.equals("/")){
            result= a/b;
        }
        return result;
    }
}
