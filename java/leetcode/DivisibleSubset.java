//Leetcode problem 368 Largest Divisible Subset
//Solution written by Xuqiang Fang on 29 May, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>(); 
        int n = nums.length;
        if(n == 0){
            return ans;
        }
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] route = new int[n];
        Arrays.fill(dp, 1);
        Arrays.fill(route, -1);
        int max = 1;
        int index = 0;
        for(int i=1; i<n; ++i){
            for(int j=i-1; j>=0; --j){
                if(nums[i] % nums[j] == 0){
                    if(1+dp[j] > dp[i]){
                        dp[i] = 1 + dp[j];
                        route[i] = j;
                    }
                }
            }
            if(dp[i] > max){
                max = dp[i];
                index = i;
            }
        }
        int[] t = new int[max];
        for(int i=max-1; i>=0; --i){
            t[i] = nums[index];
            index = route[index];
        }
        for(int i=0; i<max; ++i){
            ans.add(t[i]);
        }
        return ans;
    }
}

public class DivisibleSubset{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,4,8};
        System.out.println(s.largestDivisibleSubset(nums));
	}
}
