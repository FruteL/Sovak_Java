package com.company;

import java.util.Locale;

/**
 * Here is 3 different possible way to find palindrome
 * V1 use StringBuilder class. its easy to use, but not the best variant
 * V2 not so good. use to many Memory
 * V3 much better
 * not forget about using preparation before check String on isPolindrome
 */

public class Palindrome {

    public static boolean isPalindromeV1(String str){
        String reverse = reverseString(str);
        return str.equals(reverse);
    }

    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static boolean isPalindromeV2(String str){
        String reverse = "";
        for (int i = 0; i < str.length(); i++) {
            reverse += str.charAt(str.length()-i-1);
        }
        return str.equals(reverse);
    }

    public static boolean isPalindromeV3(String str){
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i)!=str.charAt(str.length()-i-1))
                return false;
        }
        return true;
    }

    public static String preparation(String str){
        str = str.toLowerCase(Locale.ROOT).replaceAll("[^a-zА-я]", "");
        return str;
    }

    public static void main(String[] args){
        String string = "Я — арка края";
        System.out.println(isPalindromeV3(preparation(string)));
    }

}
