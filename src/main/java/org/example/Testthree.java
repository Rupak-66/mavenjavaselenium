package org.example;

import java.util.HashSet;
import java.util.Set;

public class Testthree {
    public static void main(String[] args) {
        String str = "apple";

//        for (int i = 0; i < str.length(); i++) {
//            if(str.indexOf(str.charAt(i)) != str.lastIndexOf(str.charAt(i))){
//                System.out.println(str.charAt(i));
//            }
//
//        }

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            if(set.add(str.charAt(i))){

            }else{
                System.out.println(str.charAt(i));
            }

        }

    }
}
