package com.company;

/**
 * Here is a code for first exercise in first practical.
 * Here is 8 primitive and short story about myself.
 * There is nothing more to write about here
 */
public class Primitive {

    public static void main(String[] args) {
        byte age = 22;
        short booksHours = 4000;
        float weight = 59.6f;
        double chance = 0.00000001d;
        int people = 993120;
        long stars = 30_000_000_000l;
        char symbol = '\u2197';
        boolean answer = true;

        System.out.println("Hi! I am " + age +
                " years old. I live in Odessa. There are near " + people +
                " peoples live. My weight is " + weight +
                " kg. \nI like to read. I prefer fantasy novels and visual novels. I think i spend near " + booksHours+
                " hours on it by last 10 years. \nI believe that everything is possible. We live in universe where more than " + stars +
                " stars. One time i win in game when have chance just " + chance + " (stonks)"  + symbol +
                "\nSo, i done this task? i think it's " + answer);

    }
}
