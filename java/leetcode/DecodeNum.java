//Leetcode problem 91 Decode Ways
//Solution written by Xuqiang Fang on 3 March 2018 
/*
A-1 Z-26 Given a nums string how many ways to decode it
*/

import java.lang.Integer;

class Solution{
	public int numDecodings(String s){
		if(s.length() <= 0)
			return 0;

		int[] nums = new int[s.length()];
		nums[0] = 1;
		if(s.length() <= 2){
			if(Integer.valueOf(s.substring(0,2))<=26){
				nums[1] = 2;
			}
			else{
				nums[1] = 1;
			}
		}
		if(s.length() <= 3){
			if(Integer.valueOf(s.substring(1,3))<=26){
				nums[2] = nums[1]+1; 
			}
			else
				nums[2] = nums[1];
		}
		for(int i=3; i<s.length(); i++){
			int x = 0;
			if(Integer.valueOf(s.substring(i-1,i+1))<=26){
				x = 2 * nums[i-2];
			}else{
				x = nums[i-2];
			}	

			if(Integer.valueOf(s.substring(i-2,i))<=26){
				x = nums[i-3];
			}
			nums[i] = x;
		}
		return nums[s.length()-1];	
	}
}

public class DecodeNum{
	public static void main(String[] args){
		Solution s = new Solution();
		String a = "12121";
		String b = "916";
		System.out.println(s.numDecodings(a));
		System.out.println(s.numDecodings(b));
	}
}
