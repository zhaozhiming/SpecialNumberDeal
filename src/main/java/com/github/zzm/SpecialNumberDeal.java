package com.github.zzm;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.util.List;

public class SpecialNumberDeal {
    private static final ImmutableMap<Integer, String> NUMBER_STRING = ImmutableMap.of(
            3, "Fizz",
            5, "Buzz"
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
            if (index % specialNumber == 0) return specialNumber;
        }
        throw new RuntimeException("error");
    }

    private static boolean isSpecial(int[] specialNumbers, int index) {
        for (int specialNumber : specialNumbers) {
            if (index % specialNumber == 0) return true;
        }
        return false;
    }
}
