package com.fishercoder;

import com.fishercoder.solutions._434;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class _434Test {
    private static _434 test;
    private static int expected;
    private static int actual;
    private static String s;

    @BeforeClass
    public static void setup() {
        test = new _434();
    }

    @Before
    public void setupForEachTest() {
        expected = 0;
        actual = 0;
    }

    @Test
    public void test1() {
        s = "Hello, my name is John";
        expected = 5;
        actual = test.countSegments(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        s = ", , , ,        a, eaefa";
        expected = 6;
        actual = test.countSegments(s);
        assertEquals(expected, actual);
    }
}
