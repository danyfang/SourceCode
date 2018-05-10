//Leetcode problem 136. Single Number
//Leetcode problem 260 . Single Number II
//Solution written by Xuqiang Fang on 5 March 2018 
/*
Given an array of integers, every element appears twice except for one.
Find that single one.
Solve it in linear time and without extra memory
*/

import java.util.Set;
import java.util.HashSet;

// This XOR operation is awesome
class Solution{
	public int singleNumber(int[] nums){
		//
		int result = 0;
		for(int i=0; i<nums.length; i++){
			result ^= nums[i];
		}
		return result;
	}	

    public int[] singleNumber2(int[] nums){
        Set<Integer> set = new HashSet<>(); 
        for(int i : nums){
            if(set.contains(i))
                set.remove(i);
            else
                set.add(i);
        }
        Integer[] result = set.toArray(new Integer[0]);
        int[] res = new int[result.length];
        for(int i=0; i<res.length; ++i)
            res[i] = result[i];
        return res;
    }
}

public class SingleNumber{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = new int[]{1,1,8,3,3,4,4,5,5};
		//System.out.println(s.singleNumber(nums));
        int[] nums2 = {1,2,1,3,2,5};
        int[] res = s.singleNumber2(nums2);
        for(int i : res)
            System.out.println(i);
	}
}
