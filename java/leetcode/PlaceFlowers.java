//Leetcode problem 605 Can Place Flowers
//Solution written by Xuqiang Fang on 30 April, 2018

class Solution{

    public boolean canPlaceFlowers(int[] nums, int n){
        int m = nums.length;
        int can = 0;
        int[] dp = new int[m+2];
        for(int i=0; i<m; ++i){
            dp[i+1] = nums[i];
        }
        for(int i=1; i<=m; ++i){
            if(dp[i] == 0 && dp[i-1] == 0 && dp[i+1] == 0){
                dp[i] = 1;
                can++;
            }
        }
        return can >= n;
    }
}

public class PlaceFlowers{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,0,0,0,0,1};
        System.out.println(s.canPlaceFlowers(nums, 2));
	}
}
