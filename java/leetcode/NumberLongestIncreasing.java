//Leetcode problem 673 Number of Longest Increasing Subsequence
//Solution written by Xuqiang Fang on 1 May, 2018 

class Solution{
    //this one can only find the length of longest increasing subsequence
    public int findLIS(int[] nums){
        if(nums == null || nums.length == 0)
            return 0;
        int n = nums.length;
        int[] dp = new int[n+1];
        //dp[i] longest increasing subsequence length of array[0,...i-1];
        dp[1] = 1;
        for(int i=2; i<=n; ++i){
            for(int j=0; j<i-1; ++j){
                if(nums[i-1]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j+1]+1);
                }
                else{
                    dp[i] = Math.max(dp[i], dp[j+1]);
                }
            }
        }
        for(int i : dp){
            System.out.println(i);
        }
        /*
        int temp = 1;
        int count = 1;
        for(int i=1; i<=n; ++i){
            while(i <= n && dp[i] == dp[i-1]){
                i++;
                temp++; 
                continue;
            }
            count *= temp;
            temp = 1;
        }
        */
        return dp[n];
    }	
    //solution by user@caihao0727mail
    /*
    len[i], the length of LIS which ends with nums[i]
    count[i], the number of LIS which ends with nums[i]
    */
    public int findNumberOfLIS(int[] nums){
        int n = nums.length;
        int res = 0;
        int max = 0;
        int[] len = new int[n];
        int[] count = new int[n];
        for(int i=0; i<n; ++i){
            len[i] = count[i] = 1;
            for(int j=0; j<i; ++j){
                if(nums[i]>nums[j]){
                    if(len[i] == len[j]+1){
                        count[i] += count[j];
                    }
                    else if(len[i] < len[j]+1){
                        len[i] = len[j]+1;
                        count[i] = count[j];
                    }
                }
            }
            if(max == len[i]){
                res += count[i];
            }
            else if(max < len[i]){
                max = len[i];
                res = count[i];
            }
        }
        return res;
    }
}

public class NumberLongestIncreasing{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,3,5,4,7,9,8,11,10};
        int[] nums2 = {2,2,2,2,2};
        int[] nums3 = {1,2,4,3,5,4,7,2};
        System.out.println(s.findNumberOfLIS(nums));
        System.out.println(s.findNumberOfLIS(nums2));
        System.out.println(s.findNumberOfLIS(nums3));
	}
}
