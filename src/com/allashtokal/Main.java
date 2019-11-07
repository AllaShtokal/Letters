package com.allashtokal;

import java.util.Random;
import java.util.Scanner;

import static com.allashtokal.Constants.FIRST;
import static com.allashtokal.Constants.LAST;

/**
 * Created by IntelliJ IDEA.
 * Project name: Letters
 * User: Alla
 * Date: 07.11.2019
 * Time: 12:01
 *
 * Написать программу игры в угадывание букв.
 * Пользователь должен угадать загаданную программой латинскую букву вводя свой вариант буквы с клавиатуры.
 * Если пользователь угадал букву, программа выводит сообщение о выигрыше и количестве попыток пользователя.
 * Если буква не угадана, программа предлагает ввести другую букву. При этом программа выводит подсказки. Если пользователь
 * ввел букву меньше загаданной – вывести сообщение об этом (например, «Too low!»). Аналогично при вводе буквы больше загаданной
 * (например, «Too high!»). Если введена не латинская буква – предложить пользователю внимательно ознакомиться с правилами игры.
 * Программа должна быть не чувствительна к регистру введенной пользователем буквы. Например, при загаданной букве ‘G’ ответы
 * пользователя ‘G’ или ‘g’ в равной степени считаются правильными.
 * Игра продолжается до выигрыша пользователя.
 */

public class Main {


    public static void main(String[] args) {
        final int letter = generateBetween(FIRST, LAST);
        char input = 0;
        int attempts =0;


        System.out.println("Enter letter:");

        while (input != letter) {
            input = readSymbol();
            attempts++;
            if (!isLatinLetter(input)) {
                System.out.println("ReRead rules!");
            } else if (input == letter) {
                System.out.println("You are won! That's your " + attempts + " attempt. Good job :D");
            } else if (input > letter)
                System.out.println("Too High!");
            else System.out.println("Too Low!");

        }

    }


    private static boolean isLatinLetter(char c) {
        return (c >= FIRST && c <= LAST);
    }


    private static int generateBetween(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    private static char readSymbol() {
        Scanner s = new Scanner(System.in);
        return Character.toUpperCase(s.next().charAt(0));

    }


}
