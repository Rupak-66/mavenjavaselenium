package org.example;

import java.util.regex.Pattern;

public class Testregex {
    public static void main(String[] args) {
//        String str = "+2.98%";
//        String pattern = "^\\+?\\d+(\\.\\d+)%$";
////        Pattern pattern1 = Pattern.matches("^\\+?\\d+(\\.\\d+)%$", );
//        System.out.println(str.matches(pattern));

//        System.out.println(count);
//int ct = 0;
//        for (int i = 0; i < str.length(); i++) {
//            if(Character.isAlphabetic(str.charAt(i))){
//                ct++;
//            }
//        }
//        System.out.println(ct);


        String add = "ABCD-498-XYZ";

        String p = "^[A-Z]{3,}-\\d{3}-[A-Z]{3}$";

        System.out.println(check(add, p));


    }

    public static boolean check(String text, String pattern){
        return text.matches(pattern);
    }
}
