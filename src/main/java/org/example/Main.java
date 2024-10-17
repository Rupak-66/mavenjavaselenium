package org.example;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {


//        int i = 4;
//
//        int[] arr = {4};
//
//        System.out.println(i/0);
//
//        System.out.println("Hello world");

        try{
            String[] name_array = {"John", "Lee", "Mike"};
            String name = "Bill";

//            for(String str: name_array){
//                if(str.equals(name)){
//                    System.out.println("Name found");
//                }
//            }
            if(Arrays.asList(name_array).contains(name)){
                System.out.println("Name found");
            }else{
                throw new NameNotFoundException("Name "+name+" not found");
            }

        } catch (NameNotFoundException e1) {
            System.out.println(e1.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array out of bound exception");
        } catch (ArithmeticException e) {
            System.out.println("Match exception");
        }
        catch (Exception e) {
           System.out.println(e.getMessage());
       }finally {
            System.out.println("finally blocke excecuted");
        }
        System.out.println("Hello");
    }
}

class CustomException extends Exception{
    public CustomException(String message){
        super(message);
    }
}

class NameNotFoundException extends Exception{
    public NameNotFoundException(String message){
        super(message);
    }
}