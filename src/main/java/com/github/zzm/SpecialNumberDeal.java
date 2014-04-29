package com.github.zzm;

import com.google.common.collect.Lists;

import java.util.List;

public class SpecialNumberDeal {
    public static List<String> deal(int[] specialNumbers, int loopTimes) {
        List<String> result = Lists.newArrayList();
        for (int index = 1; index <= loopTimes; index++) {
            if (isMultiple(specialNumbers, index)) {
                result.add(index + "");
                continue;
            }

            result.add("Fizz");
        }
        return result;
    }

    private static boolean isMultiple(int[] specialNumbers, int index) {
        return index % specialNumbers[0] != 0;
    }
}
