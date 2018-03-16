//Leetcode problem 202 Happy Number
//Solution written by Xuqiang Fang on 16 March 2018 
//Solution accepted
//Actually it misses an explanation why there will be a loop
import java.util.List;
import java.util.ArrayList;

class Solution{
	public boolean isHappy(int n){
		int s = n;
		List<Integer> list = new ArrayList<>();
		while(true){
			list.add(s);	
			s = sum(split(s));
			if(s == 1)
				return true;
			if(list.contains(s))
				break;
		}
		return false;
	}	
	public int[] split(int n){
		int[] nums = new int[String.valueOf(n).length()];
		for(int i=0; i<nums.length; i++){
			nums[i] = n % 10;	
			n = (n - nums[i])/10;
		}
		return nums;
	}
	public int sum(int[] nums){
		int s = 0;
		for(int i=0; i<nums.length; i++){
			s += nums[i] * nums[i];
		}
		return s;
	}
}

public class HappyNumber{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.isHappy(Integer.valueOf(args[0])));
	}
	public static void print(int[] nums){
		for(int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
