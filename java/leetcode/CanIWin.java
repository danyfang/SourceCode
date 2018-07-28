//Leetcode problem 464 Can I Win 
//Solution written by Xuqiang Fang on 25 July, 2018
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
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((1+maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal){
            return false;
        } 
        else if(desiredTotal <= maxChoosableInteger){
            return true;
        }
        int[] used = new int[maxChoosableInteger];
        Map<String, Boolean> map = new HashMap<>();
        return dfs(used, desiredTotal, map);
    }
    // be the first to reach desired total
    private boolean dfs(int[] used, int t, Map<String, Boolean> map){
        if(t <= 0){
            return false;
        }
        String key = getKey(used);
        if(!map.containsKey(key)){
            for(int i=0; i<used.length; ++i){
                if(used[i] == 0){
                    used[i] = 1;
                    if(!dfs(used, t-i-1, map)){
                        map.put(key, true);
                        used[i] = 0;
                        return true;
                    }
                    used[i] = 0;
                }
            }
            map.put(key, false);
        }
        return map.get(key);
    }
    private String getKey(int[] used){
        StringBuilder sb = new StringBuilder();
        for(int i : used){
            sb.append(i);
        }
        return sb.toString();
    }
}

public class CanIWin{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.canIWin(10, 11));
        System.out.println(s.canIWin(10, 12));
        System.out.println(s.canIWin(10, 13));
        System.out.println(s.canIWin(10, 14));
        System.out.println(s.canIWin(10, 31));
	}
}
