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
                result.add(index + "");
                continue;
            }

            result.add(NUMBER_STRING.get(whichSpecialNumber(specialNumbers, index)));
        }
        return result;
    }

    private static int whichSpecialNumber(int[] specialNumbers, int index) {
        for (int specialNumber : specialNumbers) {
            if (isMultiple(specialNumber, index)) return specialNumber;
            if (isContains(specialNumbers, index)) return specialNumbers[0];
        }
        throw new RuntimeException("can't found special number");
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
