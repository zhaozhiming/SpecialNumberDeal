package com.github.zzm;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;

import static java.lang.String.valueOf;

public class SpecialNumberDeal {
    private static final ImmutableMap<Integer, String> NUMBER_STRING = ImmutableMap.of(
            3, "Fizz",
            5, "Buzz",
            7, "Whizz"
    );

    public static List<String> deal(int[] specialNumbers, int loopTimes) {
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

    private static String specialString(int[] specialNumbers, int index) {
        StringBuilder result = new StringBuilder();
        for (int specialNumber : specialNumbers) {
            if (isContains(specialNumbers, index)) return NUMBER_STRING.get(specialNumbers[0]);

            if (isMultiple(specialNumber, index)) {
                result.append(NUMBER_STRING.get(specialNumber));
            }
        }
        return result.toString();
    }

    private static boolean isSpecial(int[] specialNumbers, int index) {
        for (int specialNumber : specialNumbers) {
            if (isMultiple(specialNumber, index)) return true;
            if (isContains(specialNumbers, index)) return true;
        }
        return false;
    }

    private static boolean isMultiple(int specialNumber, int index) {
        return index % specialNumber == 0;
    }

    private static boolean isContains(int[] specialNumbers, int index) {
        return valueOf(index).contains(valueOf(specialNumbers[0]));
    }

}
