package ru.sber.javaschool.homework.hw1.calculator;

import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите выражение: ");
            String statement = scanner.nextLine();
            System.out.println(calculator.evaluate(statement));
        }
    }
}
