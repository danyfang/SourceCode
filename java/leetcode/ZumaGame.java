//Leetcode problem 488 Zuma Game
//Solution written by Xuqiang Fang on 4 July, 2018
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
    public int findMinStep(String b, String h) {
        if(b.length() == 0){
            return 0;
        } 
        Map<Character, Integer> map = new HashMap<>();
        for(Character c : h.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        return dfs(b, map);
    }
    private int dfs(String b, Map<Character, Integer> m){
        b = remove(b);
        //System.out.println(b);
        if(b.length() == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        for(int i=0; i<b.length(); ++i){
            char c = b.charAt(i);
            if(m.getOrDefault(c, 0) >= 1){
                String t = b.substring(0,i) + String.valueOf(c) + b.substring(i);
                m.put(c, m.get(c)-1);
                String s = remove(t);
                if(s.length() < t.length()){
                    int tmp = dfs(s, m);
                    if(tmp >= 0){
                        min = Math.min(min, tmp+1);
                    }
                }
                m.put(c, m.get(c)+1);
            }
        }
        for(int i=0; i<b.length(); ++i){
            char c = b.charAt(i);
            if(m.getOrDefault(c, 0) >= 2){
                String t = b.substring(0,i) + String.valueOf(c) + String.valueOf(c) + b.substring(i);
                m.put(c, m.get(c)-2);
                String s = remove(t);
                if(s.length() < t.length()){
                    int tmp = dfs(s, m);
                    if(tmp >= 0){
                        min = Math.min(min, tmp+2);
                    }
                }
                m.put(c, m.get(c)+2);
            }
        }
        if(min == Integer.MAX_VALUE){
            return -1;
        }
        return min;
    }
    private String remove(String b){
        for(int i=0; i<b.length()-2; ++i){
            if(b.charAt(i) == b.charAt(i+1) && b.charAt(i+1) == b.charAt(i+2)){
                int j = i+3;
                while(j < b.length() && b.charAt(j) == b.charAt(i)){
                    ++j;
                }
                String ans = b.substring(0,i);
                if(j < b.length()){
                    ans += b.substring(j);
                }
                return remove(ans);
            }
        }
        return b;
    }

    private String remove_(String b){
        for(int i=0, j=0; j<b.length(); ++j){
            if(b.charAt(i) == b.charAt(j)){
                continue;
            }
            if(j - i >= 3){
                return remove_(b.substring(0,i)+b.substring(j));
            }
            i = j;
        }
        return b;
    }
    private int max = 6;
    public int findMinStep_(String b, String h){
        int[] d = new int[26];
        for(char c : h.toCharArray()){
            d[c-'A']++;
        }
        int ans = helper(b+"#", d);
        return ans == max ? -1 : ans;
    }
    private int helper(String b, int[] d){
        b = remove_(b);
        if(b.equals("#")){
            return 0;
        }
        int ans = max, need = 0;
        for(int i=0, j=0; j < b.length(); ++j){
            char c = b.charAt(i);
            if(c == b.charAt(j)){
                continue;
            }
            need = 3 - (j - i);
            if(d[c-'A'] >= need){
                d[c-'A'] -= need;
                ans = Math.min(ans, need + helper(b.substring(0,i)+ b.substring(j), d));
                d[c-'A'] += need;
            }
            i = j;
        }
        return ans;
    }
}

public class ZumaGame{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findMinStep("WRRBBW", "RB"));
        System.out.println(s.findMinStep("WWRRBBWW", "WRBRW"));
        System.out.println(s.findMinStep("G", "GGGGG"));
        System.out.println(s.findMinStep("RBYYBBRRB", "YRBGB"));
        System.out.println(s.findMinStep_("RWYWRRWRR", "YRY"));//should be 3
        System.out.println(s.findMinStep("RWYWRRWRR", "YRY"));//should be 3
	}
}
