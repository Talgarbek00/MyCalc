package com.company;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scanner.nextLine();
        calc(str);
        exception(str);
    }
    public static void calc(String str) {
        String[] subStr = str.split("[-+*/]");
        try {
            int number1 = Integer.parseInt(subStr[0]);
            int number2 = Integer.parseInt(subStr[1]);
            int index1 = str.indexOf("+");
            int index2 = str.indexOf("-");
            int index3 = str.indexOf("*");
            int index4 = str.indexOf("/");

            if (index1 != -1) System.out.println(number1 + number2);
            if (index2 != -1) System.out.println(number1 - number2);
            if (index3 != -1) System.out.println(number1 * number2);
            try {
                if (index4 != -1) System.out.println(number1 / number2);
            } catch (ArithmeticException e) {
                System.out.println(e);
            }
        } catch (NumberFormatException e) {
            System.out.println( e);
        }
    }
    public static void exception(String str) {
        try {
            if (!str.contains("+") &&
                    !str.contains("-") &&
                    !str.contains("*") &&
                    !str.contains("/")) {
                throw new RuntimeException();
            }
        } catch (RuntimeException e) {
            System.out.println("error"+e);
            System.exit(0);
        }
    }
}