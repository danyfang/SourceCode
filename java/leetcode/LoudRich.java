//Leetcode problem 851 Loud and Rich
//Solution written by Xuqiang Fang on 11 June, 2018
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
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int[] r : richer){
            if(!map.containsKey(r[1])){
                map.put(r[1], new HashSet<>());
            }
            map.get(r[1]).add(r[0]);
        }
        int[] ans = new int[n];
        Arrays.fill(ans, n);
        Map<Integer, Integer> s = new HashMap<>();
        for(int i=0; i<n; ++i){
            s.put(quiet[i], i);
            ans[i] = dfs(map, quiet, ans, n, i);
        }
        for(int i=0; i<n; ++i){
            ans[i] = s.get(ans[i]);
        }
        return ans;
    }
    private int dfs(Map<Integer, Set<Integer>> m, int[] q, int[] a, int n, int i){
        if(a[i] != n){
            return a[i];
        }
        if(!m.containsKey(i) || q[i] == 0){
            return q[i];
        }
        int t = q[i];
        for(int k : m.get(i)){
            t = Math.min(t, q[k]); 
            t = Math.min(t, dfs(m, q, a, n, k));
        }
        return t;
    }
}

public class LoudRich{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3,2,5,4,6,1,7,0};
        int[] ans = s.loudAndRich(richer, quiet);
        for(int i : ans){
            System.out.print(i + " ");
        }
        System.out.println("");
	}
}
