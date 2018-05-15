//Leetcode problem 312 Burst Balloons
//Solution written by Xuqiang Fang on 2 May, 2018 
//define dp[i][j] as the max coins obtained from subarray [i,...,j]
class Solution{
    public int maxCoins(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] temp = new int[n+2];
        temp[0] = temp[n+1] = 1;
        for(int i=0; i<n; ++i){
            temp[i+1] = nums[i];
        }
        nums = temp;
        int[][] dp = new int[n+2][n+2]; 
        for(int l=1; l<=n; ++l){
            for(int i=1; i<=n-l+1; ++i){
                int j = i+l-1;
                for(int k=i; k<=j; ++k){
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1]+nums[i-1]*nums[k]*nums[j+1]+dp[k+1][j]);
                }
            }
        }
        return dp[1][n];
    }	
}

public class BurstBalloonsCoins{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,1,5,8};
        System.out.println(s.maxCoins(nums));
	}
}
