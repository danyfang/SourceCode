//Leetcode problem No 300 Longest Increasing Subsequence
//Solution written by Xuqiang Fang on 23 April, 2018 
import java.util.Arrays;
class Solution{
    public int lengthOfLIS_(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;

        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
            dp[i]++;
            max = Math.max(dp[i], max);
            System.out.println(dp[i]);
        }

        return max;
    }	
    

    /*
    A classic solution to the classic problem Longest Increasing Subsequence
    tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

    len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    len = 3   :      [4, 5, 6]            => tails[2] = 6
    We can easily prove that tails is a increasing array.
    Therefore it is possible to do a binary search in tails array to find the one needs update.

    Each time we only do one of the two:

    (1) if x is larger than all tails, append it, increase the size by 1
        When we traverse the nums array from left to right, the current biggest would always be at the end
    (2) if tails[i-1] < x <= tails[i], update tails[i]
        When situation 2 happens, we can replace tails[i] but still the final length won't change
    Doing so will maintain the tails invariant. The the final answer is just the size.
    */
    public int lengthOfLIS(int[] nums){
        int n = nums.length;
        int[] t = new int[n];
        int ans = 0;
        for(int x : nums){
            int i = Arrays.binarySearch(t, 0, ans, x);
            if(i < 0){
                i = -(i+1);
            }
            t[i] = x;
            if(i == ans){
                ans++;
            }
        }
        return ans;
    }
}

public class LongestIncreasingSub{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(s.lengthOfLIS(nums));
	}
}
