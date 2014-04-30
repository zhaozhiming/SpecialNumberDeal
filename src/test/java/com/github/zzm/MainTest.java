package com.github.zzm;


import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MainTest {
    private InputStream oldIn;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        oldIn = System.in;
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(oldIn);
    }

    @Test
    public void should_throw_exception_when_given_number_size_not_3() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("number length should be 3");

        System.setIn(new ByteArrayInputStream("3 5 7 9".getBytes()));
        Main.main(null);
    }

    @Test
    public void should_throw_exception_when_given_number_large_than_10() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("number should less than 10");

        System.setIn(new ByteArrayInputStream("3 15 7".getBytes()));
        Main.main(null);
    }

    @Test
    public void should_throw_exception_when_given_same_number() throws Exception {
        expectedException.expect(RuntimeException.class);
        expectedException.expectMessage("number should not be same");

        System.setIn(new ByteArrayInputStream("3 3 7".getBytes()));
        Main.main(null);
    }

}