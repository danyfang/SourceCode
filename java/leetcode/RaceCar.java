//Leetcode problem 818 Race Car
//Solution written by Xuqiang Fang on 30 July, 2018
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
    /**
    basically there are two strategies, 
    first go at least over or the same point as the target then turn back to reach the target
    second go less than the target and then turn back  some steps and then turn again to reach the target
    */  
    public int racecar(int target){
        int[] dp = new int[target+1];
        return helper(dp, target);
    }
    private int helper(int[] dp, int t){
        if(dp[t] > 0){
            return dp[t];
        }
        int s = 1;
        int n = 0;
        while(s < t+1){
            s *= 2;
            n++;
        }
        //System.out.println("s = " + s);
        if(s == t+1){
            return dp[t] = n;
        }
        dp[t] = n + 1 + helper(dp, s-1-t);
        for(int m=0; m<n-1; ++m){
            int cur = s/2 - (1<<m);
            dp[t] = Math.min(dp[t], n+m+1+helper(dp, t-cur));
        }
        return dp[t];
    }
}

public class RaceCar{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.racecar(Integer.parseInt(args[0])));
	}
}
