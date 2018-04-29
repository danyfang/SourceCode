//Leetcode problem 523 Continuous Subarray Sum
//Solution written by Xuqiang Fang on 27 April, 2018 
//the key point here is the corresopondance between sum and l and r
//whenever l and r changes, the sum should follow and should alawys 
//show the correct sum for numbers in nums array from index l to r
import java.util.HashMap;
import java.util.Map;
class Solution{
    //this solution is for another problem, the sum is equal to k but not multiple of k
    public boolean check(int[] nums, int k){
        if(nums == null || nums.length <= 1 )
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

    public boolean checkSubarray(int[] nums, int k){
        if(nums == null || nums.length <= 1 )
            return false;
        int n = nums.length;
        if(k == 0){
            for(int i=1; i<n; ++i){
                if(nums[i]+nums[i-1] == 0)
                    return true;
            }
            return false;
        }
        int[][] dp = new int[n][n];//dp[i][j], sum of subarray from i to j
        for(int i=0; i<n; ++i){
            dp[i][i] = nums[i];
        }
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                dp[i][j] = dp[i][j-1] + nums[j];
                if(dp[i][j] % k == 0)
                    return true;
            }
        }
        return false;
    }
    public boolean checkSubarraySum(int[] nums, int k){
        if(nums == null || nums.length <= 1 )
            return false;

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(){{put(0,-1);}};;
        int sum = 0;
        for(int i=0; i<nums.length; ++i){
            sum += nums[i];

            if(k != 0)
                sum %= k;
            Integer prev = map.get(sum);
            if(prev != null){
                if(i-prev > 1)
                    return true;
            }
            else
                map.put(sum, i);
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
