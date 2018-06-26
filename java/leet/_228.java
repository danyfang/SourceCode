package com.fishercoder.solutions;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

 For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 */
public class _228 {

    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            String start = String.valueOf(nums[i]);
            int tmpI = i;
            while ((i + 1) < nums.length && (nums[i] + 1) == nums[i + 1]) {
                i++;
            }
            if (tmpI == i) {
                result.add(start);
            } else {
                result.add(start + "->" + String.valueOf(nums[i]));
            }
        }
        return result;
    }

    public static void main(String... args) {
        int[] nums = new int[]{0, 1, 2, 4, 5, 7};
        List<String> result = summaryRanges(nums);
        for (String s : result) {
            System.out.println(s);
        }
    }

}
