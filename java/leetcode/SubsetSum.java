//Leetcode problem 416 Partition Equal Subset Sum
//Solution written by Xuqiang Fang on 4 April, 2018
import java.util.Arrays;
class Solution{
    public boolean canPartition(int[] nums){
        int sum = 0;
        for(int i : nums){
            sum += i;
        } 

        if((sum & 1) == 1)
            return false;

        sum >>= sum;
        boolean[] dp = new boolean[sum+1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for(int i : nums){
            for(int j=sum; j>=i; j--){
                dp[j] = dp[j] || dp[j-i];
            }
        }
        return dp[sum];
    }	
}

public class SubsetSum{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
