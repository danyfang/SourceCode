//Leetcode problem 354 Russian Doll Envelopes
//Solution written by Xuqiang Fang on 19 June, 2018
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
import java.util.Comparator;
class Solution{
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        if(n == 0){
            return 0;
        }
        Arrays.sort(envelopes, new MyCom());
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int ans = 1;
        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
class MyCom implements Comparator<int[]>{
    public int compare(int[] a, int[] b){
        if(a[0] == b[0]){
            return a[1] - b[1];
        } 
        return a[0] - b[0];
    }
}

public class RussianDoll{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        System.out.println(s.maxEnvelopes(envelopes));
	}
}
