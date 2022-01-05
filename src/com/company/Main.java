package com.company;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scanner.nextLine();
        arabOrRoman(str);
        exception(str);
    }
    public static Object arabOrRoman(String str) {
        String arabOrRoman = "";
        ArrayList arrayList = new ArrayList(Arrays.asList("O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
                "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX"));
        String[] subStr = str.split("[-+*/]");
        String number11 = (subStr[0]);
        String number22 = (subStr[1]);
        boolean number1 = arrayList.contains(number11);
        boolean number2 = arrayList.contains(number22);
        if (number1 && number2) {
            System.out.println("-----------------");
            roman(str);
        } else {
            calc(str);
        }return arabOrRoman;
    }

    public static void roman(String str){
        String[] subStr = str.split("[-+*/]");
        String number11 = (subStr[0]);
        String number22 = (subStr[1]);

        ArrayList arrayList = new ArrayList(Arrays.asList("O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
                "IX", "X", "XI","XII", "XIII", "XIV", "XV", "XVI", "XVII","XVIII","XIX","XX"));
        int number1 = arrayList.indexOf(number11);
        int number2 = arrayList.indexOf(number22);
        boolean index1 = str.contains("+");
        boolean index2 = str.contains("-");
        boolean index3 = str.contains("*");
        boolean index4 = str.contains("/");
        int rezalt;
        if (index1) {
            rezalt = number1 + number2;
            System.out.println(arrayList.get(rezalt));
        }
            if (index2) {
                rezalt = number1 - number2;
                System.out.println(arrayList.get(rezalt));
            }
        if (index3) {
            rezalt = number1 * number2;
            System.out.println(arrayList.get(rezalt));
        }
        try {
            if (index4) {
                rezalt = number1 / number2;
                System.out.println(arrayList.get(rezalt));
            }
        } catch (ArithmeticException e) {
            System.out.println(e);
        }
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