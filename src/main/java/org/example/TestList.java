package org.example;

import java.util.*;

public class TestList {
    public static void main(String[] args) {
//        List<Integer> list = new ArrayList<>();
//        list.add(4);
//        list.add(5);
//        list.add(9);
//        list.add(2);
//        list.add(3);
//        list.add(40);
//        list.add(1);
//
//        System.out.println(list);
//
//        list.removeFirst();
//        System.out.println(list);

//        Set<String> set = new HashSet<>();
//        set.add("Apple");
//        set.add("Mango");
//        set.add("Banana");
//
//        System.out.println(set);

//        Map<String, Integer> uni = new HashMap<>();
//        uni.put("Bill", 123);
//        uni.put("Max", 456);
//        uni.put("Nill", 231);
//        uni.put("Kans", 789);
//
//        System.out.println(uni);
//
//        System.out.println(uni.get("Bill"));
//        System.out.println(uni.getOrDefault("Kans", 0));

//        String str = "Apple";
//
//        Map<Character, Integer> freq = new LinkedHashMap<>();
//
//        for(char c: str.toCharArray()) {
//            freq.put(c, freq.getOrDefault(c, 0) +1);
//        }
//
//        System.out.println(freq);

        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(5);
        list.add(9);
        list.add(2);
        list.add(3);
        list.add(40);
        list.add(1);

//        for (Integer a: list){
//            System.out.println(a);
//        }

//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }

//        Iterator<Integer> it = list.iterator();
//
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        System.out.println(it);

        String[] arr = {"Apple", "Mango", "Banana", "Kiwi"};

//        Arrays.sort(arr);
//        System.out.println(Arrays.toString(arr));

//        Arrays.sort(arr, (a, b) -> Integer.compare(a.length(), b.length()));

        Arrays.sort(arr, Comparator.reverseOrder());

        System.out.println(Arrays.toString(arr));



    }
}
