package ru.sber.javaschool.homework.hw1.Calculator;

import java.util.LinkedList;
import java.util.Scanner;

/*
    Программа реализующая функцию калькулятора по алгоритму - обратной польской записи.
    Приложение работает в консольном режиме.
    Пример ввода: (2+3)-(1*2)
 */
public class Calculator {

    public String evaluate(String statement) {
        if (statement != null) {
            return eval(statement);
        } else {
            return "ERROR: введите корректное выражение!";
        }
    }

    //Основной алгоритм решения задачи
    private static String eval(String s) {
        LinkedList<Double> st = new LinkedList<>();
        LinkedList<Character> op = new LinkedList<>();

        try {
            if (checkingBrackets(s) && s.length() != 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == '*' || s.charAt(i) == '/' || s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '.') {
                        if (s.charAt(i + 1) == '*' || s.charAt(i + 1) == '/' || s.charAt(i + 1) == '+' || s.charAt(i + 1) == '-' || s.charAt(i + 1) == '.') {
                            return "ERROR: введите корректное выражение!";
                        }
                    }

                    char c = s.charAt(i);

                    if (isDelim(c)) {
                        continue;
                    }

                    if (c == '(') {
                        op.add(c);
                    } else if (c == ')') {
                        while (op.getLast() != '(')
                            processOperator(st, op.removeLast());
                        op.removeLast();
                    } else if (isOperator(c)) {
                        while (!op.isEmpty() && priority(op.getLast()) >= priority(c))
                            processOperator(st, op.removeLast());
                        op.add(c);
                    } else if (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.') {
                        String operand = "";
                        while (i < s.length() && (Character.isDigit(s.charAt(i)) || s.charAt(i) == '.')) {
                            operand += (s.charAt(i++));
                        }
                        --i;
                        st.add(Double.parseDouble(operand.toString()));
                    } else {
                        return "ERROR: введите корректное выражение!";
                    }
                }
                while (!op.isEmpty()) {
                    processOperator(st, op.removeLast());
                }

                if (s.contains(".")) {
                    return String.valueOf(st.get(0));
                } else {
                    return String.valueOf(st.get(0).intValue());
                }
            } else {
                return "ERROR: введите корректное выражение!";
            }
        } catch (Exception exception) {
            return "ERROR: введите корректное выражение!";
        }
    }

    //Если с - это пробел, то возвращаем true
    private static boolean isDelim(char c) {
        return c == ' ';
    }

    //Если с - один из знаков операций, то возвращаем true
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    //Определяем приоритет операций
    private static int priority(char op) {
        switch (op) {   //при + или - возвращаем 1, при * или /  возвращаем 2, иначе -1
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    //Проверка на правильное количество скобок
    private static boolean checkingBrackets(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return count == 0;
    }

    //Математические операции
    private static void processOperator(LinkedList<Double> st, char op) {
        double r = st.removeLast();
        double l = st.removeLast();

        switch (op) {
            case '+':
                st.add(l + r);
                break;
            case '-':
                st.add(l - r);
                break;
            case '*':
                st.add(l * r);
                break;
            case '/':
                if (r != 0) {
                    st.add(l / r);
                    break;
                } else {
                    st.add(null);
                }
        }
    }
}