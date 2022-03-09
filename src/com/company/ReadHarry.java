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
        String[] words = splitOnWords(text);
        String[] uniq = makeArrayUniq(words);

        for (int i = 0; i < 100; i++) {
            System.out.println(uniq[i]);
        }
    }

    public static String readBook(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
    public static String[] splitOnWords(String text){
        text = text.toLowerCase(Locale.ROOT).replaceAll("[^A-Za-z ]", "");
        return text.split(" +");
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

}
