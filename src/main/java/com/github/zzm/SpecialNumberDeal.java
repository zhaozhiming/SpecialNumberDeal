package com.github.zzm;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.String.valueOf;

public class SpecialNumberDeal {
    private static Map<Integer, String> stringMap;

    public static void main(String[] args) throws IOException {
        System.out.println("please input 3 numbers, every number must <10, and not the same, use blank to split number:");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] specialNumbersString = br.readLine().split(" ");
        int[] specialNumbers = new int[specialNumbersString.length];
        for (int i = 0; i < specialNumbersString.length; i++) {
            specialNumbers[i] = Integer.valueOf(specialNumbersString[i]);
        }

        System.out.println("result :\n");
        System.out.println(deal(specialNumbers, 100));
    }


    public static List<String> deal(int[] specialNumbers, int loopTimes) {
        stringMap = createMaps(specialNumbers);

        List<String> result = Lists.newArrayList();
        for (int index = 1; index <= loopTimes; index++) {
            if (!isSpecial(specialNumbers, index)) {
                result.add(valueOf(index));
                continue;
            }

            result.add(specialString(specialNumbers, index));
        }
        return result;
    }

    private static Map<Integer, String> createMaps(int[] specialNumbers) {
        HashMap<Integer, String> map = Maps.newHashMap();
        if (specialNumbers.length > 0) map.put(specialNumbers[0], "Fizz");
        if (specialNumbers.length > 1) map.put(specialNumbers[1], "Buzz");
        if (specialNumbers.length > 2) map.put(specialNumbers[2], "Whizz");
        return map;
    }

    private static boolean isSpecial(int[] specialNumbers, int index) {
        for (int specialNumber : specialNumbers) {
            if (isMultiple(specialNumber, index)) return true;
            if (isContains(specialNumbers, index)) return true;
        }
        return false;
    }

    private static String specialString(int[] specialNumbers, int index) {
        StringBuilder result = new StringBuilder();
        for (int specialNumber : specialNumbers) {
            if (isContains(specialNumbers, index)) return stringMap.get(specialNumbers[0]);

            if (isMultiple(specialNumber, index)) {
                result.append(stringMap.get(specialNumber));
            }
        }
        return result.toString();
    }

    private static boolean isMultiple(int specialNumber, int index) {
        return index % specialNumber == 0;
    }

    private static boolean isContains(int[] specialNumbers, int index) {
        return valueOf(index).contains(valueOf(specialNumbers[0]));
    }

}
