package com.fishercoder;

import com.fishercoder.solutions._611;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by stevesun on 6/11/17.
 */
public class _611Test {
    private static _611 test;
    private static int[] nums;

    @BeforeClass
    public static void setup() {
        test = new _611();
    }

    @Test
    public void test1() {
        nums = new int[]{2, 2, 3, 4};
        assertEquals(3, test.triangleNumber(nums));
    }

    @Test
    public void test2() {
        nums = new int[]{85, 88, 57, 88, 61, 71, 24, 12, 11, 37, 37, 72, 43, 22, 65, 79, 34, 41, 37, 74, 28, 25, 73, 44, 11, 84, 29, 33, 21, 87, 87, 21, 14, 47, 45, 31, 40, 33, 85, 99, 47, 29, 13, 82, 56, 33, 47, 11, 80, 59, 16, 16, 57, 53, 37, 20, 90, 84, 97, 39, 50, 22, 44, 54, 67, 69, 46, 58, 11, 29, 89, 10, 89, 30, 12, 55, 30, 32, 23, 74, 69, 19, 48, 72, 42, 12, 19, 88, 39, 32, 98, 89, 99, 19, 78, 35, 45, 16, 22, 73, 86, 76, 39, 50, 40, 85, 85, 61, 71, 97, 48, 39, 21, 39, 35, 11, 58, 94, 37, 50, 13, 78, 67, 23, 24, 53, 98, 41, 85, 90, 85, 92, 31, 11, 46, 88, 83, 68, 87, 33, 13, 43, 95, 39, 33, 40, 47, 95, 28, 52, 91, 60, 19, 76, 80, 75, 51, 64, 67, 33, 43, 47, 15, 80, 36, 78, 33, 98, 18, 15, 77, 100, 60, 28, 51, 86, 30, 67, 48, 43, 62, 23, 82, 26, 93, 99, 19, 93, 21, 22, 34, 100, 46, 94, 42, 58, 31, 27, 81, 47, 90, 53, 85, 69, 41, 29, 73, 26, 23, 54, 59, 83, 99, 19, 28, 96, 15, 56, 40, 32, 32, 42, 85, 43, 71, 36, 98, 74, 38, 91, 11, 79, 62, 24, 34, 29, 10, 31, 54, 59, 97, 35, 23, 92, 72, 96, 52, 45, 57, 39, 69, 53, 89, 46, 44, 66, 43, 60, 62, 28, 53, 72, 82, 63, 92, 39, 20, 56, 72, 25, 36, 33, 60, 92, 29, 40, 21, 53, 45, 53, 80, 56, 42, 67, 79, 11, 39, 11, 77, 82, 97, 91, 55, 96, 73, 48, 26, 11, 90, 40, 28, 21, 35, 99, 25, 73, 39, 62, 66, 50, 72, 58, 26, 91, 96, 88, 98, 25, 99, 27, 26, 26, 40, 43, 80, 21, 99, 25, 94, 61, 32, 49, 40, 67, 91, 99, 17, 99, 76, 34, 21, 100, 14, 98, 68, 83, 54, 21, 52, 84, 37, 87, 100, 69, 43, 76, 31, 31, 39, 29, 90, 82, 37, 26, 36, 11, 37, 95, 26, 43, 29, 66, 70, 99, 88, 44, 37, 96, 83, 38, 44, 50, 48, 10, 98, 67, 58, 66, 74, 91, 24, 19, 82, 94, 94, 58, 89, 73, 92, 80, 19, 76, 60, 23, 54, 78, 55, 46, 20, 27, 88, 23, 93, 16, 60, 97, 67, 78, 86, 83, 73, 48, 32, 39, 83, 49, 58, 82, 50, 99, 67, 39, 79, 48, 76, 82, 72, 92, 32, 98, 97, 82, 44, 37, 11, 50, 94, 51, 89, 100, 46, 95, 10, 99, 39, 68, 81, 34, 61, 78, 95, 54, 85, 31, 74, 38, 95, 85, 88, 45, 78, 35, 82, 42, 19, 12, 89, 24, 42, 88, 57, 79, 82, 13, 22, 64, 66, 42, 73, 44, 54, 68, 70, 15, 27, 44, 72, 44, 49, 42, 40, 26, 50, 33, 24, 56, 79, 68, 100, 41, 42, 92, 89, 27, 50, 100, 35, 54, 89, 98, 32, 80, 15, 90, 66, 53, 27, 77, 82, 97, 58, 95, 70, 24, 79, 27, 29, 54, 90, 25, 76, 26, 90, 79, 67, 31, 85, 15, 74, 22, 59, 20, 71, 62, 15, 48, 31, 48, 91, 89, 19, 51, 17, 60, 13, 65, 44, 89, 19, 45, 72, 84, 94, 98, 21, 89, 24, 10, 19, 14, 26, 68, 100, 44, 26, 21, 65, 14, 79, 93, 48, 29, 60, 47, 84, 54, 13, 89, 45, 91, 29, 15, 65, 52, 39, 59, 13, 25, 59, 91, 22, 74, 77, 62, 95, 28, 86, 30, 24, 61, 53, 12, 16, 89, 79, 64, 36, 66, 47, 40, 13, 94, 28, 51, 64, 79, 38, 28, 54, 99, 11, 69, 22, 42, 89, 36, 62, 96, 32, 50, 24, 45, 90, 46, 13, 31, 84, 39, 84, 51, 34, 97, 13, 49, 10, 43, 42, 47, 86, 33, 76, 72, 39, 26, 77, 70, 100, 93, 64, 20, 80, 76, 48, 56, 32, 38, 56, 67, 15, 14, 14, 11, 61, 44, 31, 57, 39, 65, 71, 16, 68, 75, 47, 81, 55, 16, 80, 63, 10, 73, 81, 20, 20, 20, 34, 37, 40, 43, 44, 13, 89, 31, 75, 54, 37, 62, 76, 63, 94, 65, 82, 51, 69, 56, 76, 45, 12, 55, 25, 29, 65, 49, 16, 43, 48, 65, 20, 39, 81, 81, 61, 85, 73, 51, 81, 30, 18, 62, 54, 85, 85, 80, 59, 63, 37, 58, 32, 48, 84, 64, 50, 47, 99, 49, 62, 69, 60, 100, 67, 50, 16, 22, 65, 97, 58, 23, 70, 27, 14, 91, 84, 38, 91, 37, 31, 53, 100, 45, 29, 64, 75, 94, 70, 89, 78, 81, 70, 18, 79, 70, 83, 70, 61, 15, 42, 70, 77, 45, 36, 59, 65, 71, 41, 82, 89, 64, 48, 67, 89, 28, 20, 10, 99, 23, 27, 65, 77, 32, 96, 98, 59, 64, 99, 21, 77, 65, 43, 37, 62, 64, 78, 91, 57, 98, 75, 62, 92, 61, 27, 40, 51, 66, 55, 60, 44, 83, 71, 38, 34, 32, 72, 22, 45, 89, 26, 96, 87, 59, 92, 14, 94, 80, 44, 36, 94, 36, 21, 18, 95, 80, 88, 95, 87, 86, 53, 14, 55, 10, 24, 13, 11, 10, 61, 47, 76, 94, 75, 85, 25, 22, 22, 76, 40, 43, 69, 87, 30, 66, 43, 74, 70, 30, 94, 32, 47, 88, 95, 67, 25, 59, 64, 12, 20, 44, 48, 84, 21, 34, 63, 79, 21, 13, 33, 71, 16, 45, 37, 34, 39, 24, 64, 67, 42, 64, 65, 55, 89, 96, 72, 58, 54, 17, 43, 30, 54, 27, 82, 66, 17, 43, 41, 38, 84, 37, 93, 70, 75, 53, 81, 35, 87, 70, 77, 52, 92, 90, 19, 45, 33, 58, 20, 77, 88, 37, 49, 82, 22, 24, 63, 47};
        assertEquals(105489315, test.triangleNumber(nums));
    }

}