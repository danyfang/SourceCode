//Leetcode problem 403 Frog Jump
//Solution written by Xuqiang Fang on 22 June, 2018
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
    public boolean canCross(int[] stones) {
        //dp[i] means jumping to ith stone with dp[i] units, since there may be different number of units
        //to the current place, we need to use set to store this units
        if(stones[1] != 1){
            return false;
        }
        Map<Integer, Set<Integer>> dp = new HashMap<>();    
        int n = stones.length;
        for(int i=1; i<n; ++i){
            dp.put(stones[i], new HashSet<>());
        }
        dp.get(stones[1]).add(1);
        int[] move = {-1,0,1};
        for(int i=1; i<n-1; ++i){
            if(dp.get(stones[i]).isEmpty()){
                break;
            }
            for(int j : dp.get(stones[i])){
                for(int x : move){
                    int key = stones[i]+j+x;
                    if(j+x > 0 && dp.containsKey(key)){
                        dp.get(key).add(j+x);
                    }
                }
            } 
        }
        /*debug 
        if(!dp.get(stones[n-1]).isEmpty()){
            for(int x : dp.get(stones[n-1])){
                System.out.println(x);
            }
        }
        */
        return !dp.get(stones[n-1]).isEmpty();
    }
}

public class FrogJump{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(s.canCross(stones));
        stones = new int[]{0,1,2,3,4,8,9,11};
        System.out.println(s.canCross(stones));
	}
}
