package org.example;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class CollectionsPractice {
    public static void main(String[] args) {
        String test = "Hello world how are you?";
        String[] words = test.split(" ");
        String res="";


        for (int i = 0; i < words.length; i++) {
            StringBuilder builder = new StringBuilder(words[i]);
            res += builder.reverse().toString()+" ";
        }
        res = res.trim();

        System.out.println(res);
    }
}
