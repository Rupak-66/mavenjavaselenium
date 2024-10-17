package org.example;

import java.util.Arrays;
import java.util.Collections;

public class Maximum {
    public static void main(String[] args) {
        int[] marks = { 125, 132, 95, 116, 110 };


        int max = Integer.MIN_VALUE;

        for (int j = 0; j < marks.length; j++) {
            if(max < marks[j]){
                max = marks[j];
            }
        }

        System.out.println(max);
    }
}
