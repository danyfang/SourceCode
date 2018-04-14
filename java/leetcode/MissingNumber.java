//Leetcode problem 268 Missing Number
//Solution written by Xuqiang Fang on 14 April, 2018 

class Solution{
    public int missingNumber(int[] nums){
        int n = nums.length;
        int sum = 0;
        for(int i : nums)
            sum += i;
        return (n+1)*n/2 - sum;
    }	
    //this approaches can avoid overflow
    public int missingNumber_(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += i;
            sum -= nums[i];
        }
        sum += nums.length;
        return sum;
    }
}

public class MissingNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(s.missingNumber(nums));
	}
}
