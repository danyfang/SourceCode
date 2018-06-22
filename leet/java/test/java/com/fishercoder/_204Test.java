package com.fishercoder;

import com.fishercoder.solutions._204;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class _204Test {
    private static _204.Solution1 solution1;
    private static _204.Solution2 solution2;

    @BeforeClass
    public static void setup() {
        solution1 = new _204.Solution1();
        solution2 = new _204.Solution2();
    }

    @Test
    public void test1() {
        assertEquals(0, solution1.countPrimes(2));
        assertEquals(0, solution2.countPrimes(2));
    }

    @Test
    public void test2() {
        assertEquals(1, solution1.countPrimes(3));
        assertEquals(1, solution2.countPrimes(3));
    }

    @Test
    public void test3() {
        assertEquals(2, solution1.countPrimes(5));
        assertEquals(2, solution2.countPrimes(5));
    }

    @Test
    public void test4() {
        assertEquals(114155, solution1.countPrimes(1500000));
        assertEquals(114155, solution2.countPrimes(1500000));
    }

    @Test
    public void test5() {
        assertEquals(10, solution1.countPrimes(30));
        assertEquals(10, solution2.countPrimes(30));
    }

    @Test
    public void test6() {
        assertEquals(4, solution1.countPrimes(10));
        assertEquals(4, solution2.countPrimes(10));
    }

    @Test
    public void test7() {
        assertEquals(8, solution1.countPrimes(20));
        assertEquals(8, solution2.countPrimes(20));
    }

    @Test
    public void test8() {
        assertEquals(12, solution1.countPrimes(40));
        assertEquals(12, solution2.countPrimes(40));
    }

    @Test
    public void test9() {
        assertEquals(15, solution1.countPrimes(50));
        assertEquals(15, solution2.countPrimes(50));
    }

}
