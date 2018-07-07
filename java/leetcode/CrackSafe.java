//Leetcode problem 753 Cracking the Safe
//Solution written by Xuqiang Fang on 5 July, 2018
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
    public String crackSafe(int n, int k) {
        int size = (int)Math.pow(k, n);    
        Set<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; ++i){
            sb.append(0);
        }
        set.add(sb.toString());
        dfs(sb, set, n, k, size);
        return sb.toString();
    }
    private boolean dfs(StringBuilder sb, Set<String> set, int n, int k, int size){
        if(set.size() == size){
            return true;
        }
        for(char c='0'; c<'0'+k; ++c){
            sb.append(c); 
            String s = sb.substring(sb.length()-n);
            if(!set.contains(s)){
                set.add(s);
                if(dfs(sb, set, n, k, size)){
                    return true;
                }
                set.remove(s);
            }
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
}

public class CrackSafe{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.crackSafe(2,2));
        System.out.println(s.crackSafe(4,7));
	}
}
