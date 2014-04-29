package com.github.zzm;

import com.google.common.collect.Lists;

import java.util.List;

public class SpecialNumberDeal {
    public static List<String> deal(int[] specialNumbers, int loopTimes) {
        List<String> result = Lists.newArrayList();
        for (int i = 1; i <= loopTimes; i++) {
            if (i % specialNumbers[0] != 0) {
                result.add(i + "");
                continue;
            }

            result.add("Fizz");
        }
        return result;
    }
}
