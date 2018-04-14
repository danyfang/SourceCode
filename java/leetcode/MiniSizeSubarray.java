//Leetcode problem 209 Minimum Size Subarray Sum
//Solution written by Xuqiang Fang on 13 April, 2018 

class Solution{
    public int minSubArrayLen(int s, int[] nums){
        int i = 0;
        int j = 0;
        int sum = 0;
        int min = nums.length;
        while(j < nums.length){
            sum += nums[j];
            while(sum - nums[i] >= s){
                System.out.println("j = " + j);
                System.out.println("i = " + i);
                sum -= nums[i];
                i++;
            }
            if(sum >= s)
                min = Math.min(min, j-i+1);
            System.out.println("min = " + min);
            j++;
        }
        return sum < s ? 0 : min;
    }	
}

public class MiniSizeSubarray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {2,3,1,2,4,3};
        System.out.println(s.minSubArrayLen(7, nums));
	}
}
