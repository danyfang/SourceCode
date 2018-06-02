//Leetcode problem 823 Binary Tree With Factors
//Solution written by Xuqiang Fang on 1 June, 2018 
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
    public int numFactoredBinaryTrees(int[] A) {
        long mod = (int)Math.pow(10, 9) + 7;
        int n = A.length;
        Arrays.sort(A);
        long[] dp = new long[n];
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.fill(dp, 1);
        map.put(A[0], 0);
        int ans = 1;
        for(int i=1; i<n; ++i){
            for(int j=0; j<i; ++j){
                if(A[i]%A[j] == 0 && map.containsKey(A[i]/A[j])){
                    dp[i] += dp[j] * dp[map.get(A[i]/A[j])];
                    dp[i] %= mod;
                }
            }
            map.put(A[i], i);
            ans += dp[i];
            ans %= mod;
        }
        return ans;
    }   
}

public class BinaryTreeFactors{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {2,3,4,5,8,10,12,16,20,24,28,30,32,36,40,50};
        System.out.println(s.numFactoredBinaryTrees(nums));
	}
}
