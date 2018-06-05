//Leetcode problem 115 Distinct Subsequences
//Solution written by Xuqiang Fang on 5 June, 2018
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
    //unfortunately dfs solution TLE
    public int numDistinct_(String s, String t) {
        count = 0;
        dfs(s, t, new StringBuilder(), 0);
        return count;
    }
    private void dfs(String s, String t, StringBuilder sb, int index){
        if(sb.length() == t.length() && sb.toString().equals(t)){
            count++;
            return;
        }
        else if(!sb.toString().equals(t.substring(0, sb.length()))){
            return;
        }
        for(int i=index; i<s.length(); ++i){
            sb.append(s.charAt(i));
            dfs(s, t, sb, i+1);
            sb.delete(sb.length()-1, sb.length());
        }
    }
    private int count;

    public int numDistinct(String s, String t){
        //dp[i][j] is the number of subsequences in s[0,j] which equals t[0,i]
        int[][] dp = new int[t.length()+1][s.length()+1];
        Arrays.fill(dp[0], 1);
        for(int i=1; i<=t.length(); ++i){
            for(int j=1; j<=s.length(); ++j){
                //if current ending in s[0,j] and t[0, i] is equal
                //then current # is the sum of previous plus the shorter #
                if(s.charAt(j-1) == t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        return dp[t.length()][s.length()];
    }
}

public class DistinctSubsequences{
	public static void main(String[] args){
		Solution s = new Solution();
        String s1 = "rabbbit";
        String t1 = "rabbit";
        System.out.println(s.numDistinct(s1, t1));
        String s2 = "babgbag";
        String t2 = "bag";
        System.out.println(s.numDistinct(s2, t2));
        String s3 = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
        String t3 = "ceadbaa";
        System.out.println(s.numDistinct(s3, t3));
	}
}
