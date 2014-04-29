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

    @Test
    public void should_return_correct_result_when_given_special_number_3_and_loop_6_times() throws Exception {
        assertThat(SpecialNumberDeal.deal(new int[]{3}, 6), is(asList("1", "2", "Fizz", "4", "5", "Fizz")));
    }

    @Test
    public void should_return_correct_result_when_given_special_number_3_5_and_loop_6_times() throws Exception {
        assertThat(SpecialNumberDeal.deal(new int[]{3, 5}, 6), is(asList("1", "2", "Fizz", "4", "Buzz", "Fizz")));
    }

    @Test
    public void should_return_correct_result_when_given_special_number_3_5_and_loop_10_times() throws Exception {
        assertThat(SpecialNumberDeal.deal(new int[]{3, 5}, 10), is(asList("1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz")));
    }


}
