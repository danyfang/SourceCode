//Leetcode problem 44 Wildcard Matching
//Solution written by Xuqiang Fang on 4 Sep, 2018
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
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        //System.out.println(s + "," + p);
        for(int i=0; i<n; ++i){
            if(p.charAt(i) == '*' && dp[0][i]){
                dp[0][i+1] = true;
                //System.out.println("here" + m + n);
            }
            else{
                break;
            }
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(p.charAt(j) == s.charAt(i) || p.charAt(j) == '?'){
                    dp[i+1][j+1] = dp[i][j];
                }
                else if(p.charAt(j) == '*'){
                    dp[i+1][j+1] = dp[i+1][j] || dp[i][j+1]; 
                }
            }
        }
        return dp[m][n];
    }
}

public class WildcardMatching{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.isMatch(args[0], args[1]));
	}
}
