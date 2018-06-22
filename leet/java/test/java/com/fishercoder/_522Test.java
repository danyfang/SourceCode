package com.fishercoder;

import com.fishercoder.solutions._522;
import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by fishercoder on 12/31/16.
 */
public class _522Test {

    private static _522 test;
    private static int expected;
    private static int actual;
    private static String[] strs;

    @BeforeClass
    public static void setup() {
        test = new _522();
    }

    @Test
    public void test1() {
        strs = new String[]{"aaa", "aaa", "aa"};
        expected = -1;
        actual = test.findLUSlength(strs);
        assertEquals(expected, actual);
    }

}
