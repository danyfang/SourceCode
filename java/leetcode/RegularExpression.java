//Leetcode problem 10 Regular Expression Matching
//Solution written by Xuqiang Fang on 26 June, 2018
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
    public boolean isMatch(String s, String p) {
        if(s == null || p == null){
            return false;
        } 
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i=0; i<p.length(); ++i){
            if(p.charAt(i) == '*' && dp[0][i-1]){
                dp[0][i+1] = true;
            }
        }
        for(int i=0; i<s.length(); ++i){
            for(int j=0; j<p.length(); ++j){
                if(p.charAt(j) == '.' || s.charAt(i) == p.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                if(p.charAt(j) == '*'){
                    if(p.charAt(j-1) != s.charAt(i) && p.charAt(j-1) != '.'){
                        dp[i+1][j+1] = dp[i+1][j-1];
                    }
                    else{
                        dp[i+1][j+1] = (dp[i+1][j] || dp[i][j+1] || dp[i+1][j-1]);
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}

public class RegularExpression{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.isMatch("aa", "a*"));
        System.out.println(s.isMatch("ab", ".*"));
        System.out.println(s.isMatch("aab", "c*a*b"));
        System.out.println(s.isMatch("mississippi", "mis*is*p*"));
	}
}
