package com.lucaledd.aoc2023;

public class Day1 {
    public static void main(String[] args) {
        part1();
        // TODO: part 2
    }

    private static void part1() {
        // Consider your entire calibration document.
        // What is the sum of all of the calibration values?

        int sum = 0;
        for (String line : Utils.readFile("input.txt")) {
            sum += getDigitNo(line);
        }

        System.out.println(sum);
    }

    private static int getDigitNo(String data) {
        String[] array = data.split("");

        String firstDigit = null, lastDigit = null;
        for(String s : array) {
            if(isNumeric(s)) {
                if (firstDigit == null) {
                    firstDigit = s;
                } else {
                    lastDigit = s;
                }
            }
        }

        if(lastDigit == null) lastDigit = firstDigit;
        String number = firstDigit + lastDigit;
        return Integer.parseInt(number);
    }

    private static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
