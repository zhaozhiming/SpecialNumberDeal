package com.github.zzm;

import com.google.common.collect.Sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

public class Main {

    private static final int DEFAULT_TIMES = 100;

    public static void main(String[] args) throws IOException {
        System.out.println("please input 3 numbers, every number must <10, and not the same, use blank to split number:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split(" ");
        int[] specialNumbers = convertStringArrayToIntArray(strings);

        checkNumbers(specialNumbers);
        System.out.println("result :\n");
        List<String> result = SpecialNumberDeal.deal(specialNumbers, DEFAULT_TIMES);
        for (String number : result) {
            System.out.println(number);
        }
    }

    private static void checkNumbers(int[] specialNumbers) {
        checkArrayLength(specialNumbers);
        checkLessThan10(specialNumbers);
        haveSameNumber(specialNumbers);
    }

    private static void checkLessThan10(int[] specialNumbers) {
        for (int specialNumber : specialNumbers) {
            if (specialNumber >= 10)
                throw new RuntimeException("number should less than 10");
        }
    }

    private static void checkArrayLength(int[] specialNumbers) {
        if (specialNumbers.length != 3)
            throw new RuntimeException("number length should be 3");
    }

    private static void haveSameNumber(int[] specialNumbers) {
        Set<Integer> ints = Sets.newHashSet();
        for (int specialNumber : specialNumbers) {
            ints.add(specialNumber);
        }

        if (ints.size() < 3)
            throw new RuntimeException("number should not be same");
    }

    private static int[] convertStringArrayToIntArray(String[] strings) {
        int[] specialNumbers = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            specialNumbers[i] = Integer.valueOf(strings[i]);
        }
        return specialNumbers;
    }
}
