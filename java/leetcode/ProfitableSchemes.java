//Leetcode problem 879 Profitable Schemes
//Solution written by Xuqiang Fang on 29 July, 2018
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
    public int profitableSchemes(int G, int P, int[] group, int[] profit) {
        //dp[i][j] is the number of schemes for profit i and member j
        int[][] dp = new int[P+1][G+1];
        dp[0][0] = 1;
        int mod = (int)1e9 + 7;
        int n = profit.length;
        for(int i=0; i<n; ++i){
            int g = group[i];
            int p = profit[i];
            for(int k=P; k>=0; --k){
                for(int j=G-g; j>=0; --j){
                    dp[Math.min(k+p, P)][j+g] = (dp[Math.min(k+p, P)][j+g] + dp[k][j]) % mod;
                }
            }
        }
        int ans = 0;
        for(int x : dp[P]){
            ans += x;
            ans %= mod;
        }
        return ans;
    }
}

public class ProfitableSchemes{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] group = {2,3,5};
        int[] profit = {6,7,8};
        System.out.println(s.profitableSchemes(10, 5, group, profit));
	}
}
