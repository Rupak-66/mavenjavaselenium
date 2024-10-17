package org.example;

public class Forexample {

    public static void main(String[] args) {


//        for (int j = 3; j <= 120; j++) {
//            if(j % 2 == 0){
//                System.out.println(j);
//            }
//        }



//       String str = "apple";
//       String rev = "";
//
//        for (int i = str.length() - 1; i >=0 ; i--) {
////            rev += str.charAt(i);
//            rev = rev + str.charAt(i);
//        }
//        System.out.println(rev);
//
//        if(str.equals(rev)){
//            System.out.println("Palindrome");
//        }else{
//            System.out.println("Not Palindrome");
//        }

        int num = 19;
        int rev = 0;

        while (num != 0){
            int digit = num % 10;
            rev = rev * 10 + digit;
            num = num / 10;

        }
        System.out.println(rev);





    }
}
