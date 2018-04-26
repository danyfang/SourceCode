//Leetcode problem 461 Hamming Distance
//Leetcode problem 471 Total Hamming Distance
//Solution written by Xuqiang Fang on 2 March 2018
/*
The Hamming distance between two integers is the number of positions at
which the corresponding bits are different.
Given x and y calculate the hamming distance 
0<=x,y<=2^31
*/

import java.lang.Integer;

class Solution{
	public int hammingDistance(int x, int y){
		return Integer.bitCount(x^y);
	}	

    public int totalHammingDistance(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        
        int n = nums.length;
        int[] bit = new int[32];
        for(int i=0; i<32; ++i){
            int mask = 1 << i; 
            for(int j=0; j<n; ++j){
                if((mask & nums[j]) == mask){
                    bit[i]++;
                }
            }
        }
        int count = 0; 
        for(int i : bit)
            count += (n-i) * i;
        return count;
    }
}

public class HammingDistance{
	public static void main(String[] args){
		Solution s = new Solution();
		//System.out.println(s.hammingDistance(1,9));
        int[] nums = {4,14,2};
        System.out.println(s.totalHammingDistance(nums));
	}
}
