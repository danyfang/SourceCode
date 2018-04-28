//Leetcode problem 523 Continuous Subarray Sum
//Solution written by Xuqiang Fang on 27 April, 2018 
//the key point here is the corresopondance between sum and l and r
//whenever l and r changes, the sum should follow and should alawys 
//show the correct sum for numbers in nums array from index l to r
class Solution{
    //this solution is for another problem, the sum is equal to k but not multiple of k
    public boolean checkSubarraySum(int[] nums, int k){
        if(nums == null || nums.length <= 1 || k < 0)
            return false;
        int l = 0;
        int r = 0;
        int sum = nums[0];
        while(r < nums.length){
            while(sum < k && r < nums.length-1){
                sum += nums[++r];
            }
            while(sum > k){
                sum -= nums[l++];
            }
            if(sum == k && (r-l) >= 1){
                System.out.println("r = " + r);
                System.out.println("l = " + l);
                return true;
            }
            else{
                r++;
                if(r < nums.length)
                    sum += nums[r];
            }
        }

        return false;
    }	
}

public class ContinuousSubarray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {23,2,4,6,7,8,9,11};
        System.out.println(s.checkSubarraySum(nums, Integer.valueOf(args[0])));
        /*
        for(int i=0; i<100; ++i){
            if(s.checkSubarraySum(nums, i)){
                System.out.println(i);
            }
        }
        */
	}
}
