package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Locale;

/**
 * ReadHarry - class for reading and split text on words
 * Methods:
 *      - readBook() - used for get String from file by path
 *      - splitOnWords() - make all words in lower case, delete all punctuation marks and digits.
 *      After that split text on String Array
 *      - makeArrayUniq() - delete not unique words and sorted text by Alphabet
 */

public class ReadHarry {

    public static void main(String[] args) throws IOException {
        String text = readBook("harry.txt");
        System.out.println(countLinesWithWord("Harry", splitOnLines(text)));

        String[] words = splitOnWords(text);
        //System.out.println(countLinesWithWord("harry", words));

        String longest = longestWord(words);
        System.out.println(longest);

        String[] uniq = makeArrayUniq(words);
//        for (int i = 0; i < 100; i++) {
//            System.out.println(uniq[i]);
//        }

        String[] startByC = getWordsByLetter("c", uniq);
        for (int i = 0; i < startByC.length; i++) {
            System.out.println(startByC[i]);
        }


    }

    public static String readBook(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    public static String[] splitOnWords(String text){
        text = text.toLowerCase(Locale.ROOT).replaceAll("[^A-Za-z ]", "");
        return text.split(" +");
    }
    public static String[] splitOnLines(String text){
        //text = text.toLowerCase(Locale.ROOT).replaceAll("[^A-Za-z ]", "");
        return text.split("\n");
    }

    public static String[] makeArrayUniq(String[] words){
        String uniqString = "";
        for (int i = 0; i < words.length; i++) {
            if (!uniqString.contains(words[i])){
                uniqString += words[i] + " ";
            }
        }
        String[] uniqArray = uniqString.split(" ");
        Arrays.sort(uniqArray);
        return uniqArray;
    }
    public static String longestWord(String[] words){
        String longest = "";
        for (int i = 0; i < words.length; i++) {
            if(words[i].length()>longest.length()){
                longest = words[i];
            }
        }
         return longest;
    }
    public static String[] getWordsByLetter(String letter, String[] words){
        String newString = "";
        boolean flag = true;
        int pos1 = 0;
        int pos2 = 1;

        for (int i = 0; i < words.length; i++) {
            if(flag){
                if(words[i].startsWith(letter)){
                    pos1 = i;
                    flag = false;
                }
            }
            else{
                if(!words[i].startsWith(letter)){
                    pos2 = i;
                    break;
                }
            }
        }
        for (int i = pos1; i < pos2; i++) {
            newString += words[i] + " ";
        }
        return newString.split(" ");
    }

    public static int countLinesWithWord(String words, String[] text){
        int counter = 0;
        for (int i = 0; i < text.length; i++) {
            if (text[i].contains(words)){
                counter +=1;
            }
        }


        return counter;
    }




}
