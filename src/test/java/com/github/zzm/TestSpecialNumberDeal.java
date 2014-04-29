package com.github.zzm;

import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TestSpecialNumberDeal {

    @Test
    public void should_return_correct_result_when_given_special_number_3_and_loop_3_times() throws Exception {
        assertThat(SpecialNumberDeal.deal(new int[]{3}, 3), is(asList("1", "2", "Fizz")));
    }
}
