package ru.inno.java.homework5;

import java.util.Scanner;

public class Keyboard {
    public static void main(String[] args) {
        // Карта букв слева-направо
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите букву английского алфавита: ");
        char input = scanner.next().charAt(0);

        // Проверяем латинские символы
        if (keyboard.indexOf(input) == -1) {
            System.out.println("Ошибка: введен недопустимый символ");
            return;
        }

        // Проверяем позицию введенной буквы
        int position = keyboard.indexOf(input);

        // Проверяем позицию предыдущей буквы
        int leftPosition = (position - 1 + keyboard.length()) % keyboard.length();

        char leftChar = keyboard.charAt(leftPosition);
        System.out.println("Слева от '" + input + "' находится буква '" + leftChar + "'");
    }
}