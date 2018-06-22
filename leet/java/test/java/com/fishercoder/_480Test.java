package com.fishercoder;

import com.fishercoder.solutions._480;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by fishercoder on 5/27/17.
 */
public class _480Test {
    private static _480 test;
    private static int[] nums;
    private static double[] expected;
    private static int k;

    @BeforeClass
    public static void setup() {
        test = new _480();
    }

    @Test
    public void test1() {
        nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        expected = new double[]{1, -1, -1, 3, 5, 6};
        k = 3;
        assertArrayEquals(expected, test.medianSlidingWindow(nums, k), 0);
    }
}
