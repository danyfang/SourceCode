//Leetcode problem 628 Maximum Product of Three Numbers
//Solution written by Xuqiang Fang on 3 May, 2018
import java.util.Arrays;
class Solution{
    public int maximumProduct(int[] nums){
        Arrays.sort(nums);
        int n = nums.length;//n >= 3
        int max = nums[0]*nums[1]*nums[2];
        int temp = 0;
        for(int i=n; i<2*n; ++i){
            temp = nums[(i-1)%n]*nums[i%n]*nums[(i+1)%n];
            max = Math.max(temp, max);
        }
        return max;
    }	
}

public class MaximumProductThree{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {-12,-11,-10,1,2,3,4,5};
        int[] nums2 = {-12,-11,-10,-9,-8,-6,-1};
        System.out.println(s.maximumProduct(nums));
        System.out.println(s.maximumProduct(nums2));
	}
}
