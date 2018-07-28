//Leetcode problem 132 Palindrome Partitioning II
//Solution written by Xuqiang Fang on 26 July, 2018
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
    public int minCut(String s) {
        int n = s.length();
        if(n == 0){
            return 0;
        }
        int[] dp = new int[n+1];
        dp[n] = 0;
        dp[n-1] = 1;
        for(int i=n-1; i>=0; --i){
            if(isPalin(s.substring(i))){
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i+1] + 1; 
            for(int j=i+1; j<n; ++j){
                if(isPalin(s.substring(i, j))){
                    dp[i] = Math.min(dp[i], 1 + dp[j]);
                } 
            }
        }
        return dp[0];
    }
    private boolean isPalin(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l++)  != s.charAt(r--)){
                return false;
            }    
        }
        return true;
    }
}

public class PalindromePartitioning{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.minCut(args[0]));
	}
}
