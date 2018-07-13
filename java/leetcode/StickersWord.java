//Leetcode problem 691 Stickers to Spell Word
//Solution written by Xuqiang Fang on 8 July, 2018
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
    public int minStickers(String[] stickers, String target) {
        List<Map<Character, Integer>> count = new ArrayList<>();
        for(String s : stickers){
            Map<Character, Integer> map = new HashMap<>();
            for(char c : s.toCharArray()){
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            count.add(map);
        }
        Map<String, Integer> dp = new HashMap<>();
        dp.put("", 0);
        return dfs(count, target, dp);
    }
    private int dfs(List<Map<Character, Integer>> count, String t, Map<String, Integer> dp){
        if(dp.containsKey(t)){
            return dp.get(t);
        }
        Map<Character, Integer> tar = new HashMap<>();
        for(char c : t.toCharArray()){
            tar.put(c, tar.getOrDefault(c, 0)+1);
        }
        int ans = Integer.MAX_VALUE;
        for(Map<Character, Integer> c : count){
            if(!c.containsKey(t.charAt(0))){
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(char ch : tar.keySet()){
                int i = tar.get(ch) - c.getOrDefault(ch, 0);
                while(i-- > 0){
                    sb.append(ch); 
                } 
            }
            if(sb.length() < t.length()){
                int num = dfs(count, sb.toString(), dp);
                if(num != -1){
                    ans = Math.min(ans, 1+num);
                }
            }
        }
        if(ans == Integer.MAX_VALUE){
            dp.put(t, -1);
        }
        else{
            dp.put(t, ans);
        }
        return dp.get(t);
    }
}

public class StickersWord{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] stickers = {"with", "example", "science"};
        String target = "thehat";
        System.out.println(s.minStickers(stickers, target));
	}
}
