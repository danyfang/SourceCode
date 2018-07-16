//Leetcode problem 869 Reordered Power of 2
//Solution written by Xuqiang Fang on 15 July, 2018
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
    public boolean reorderedPowerOf2(int N) {
        Set<String> set = new HashSet<>();
        for(int i=0; i<32; ++i){
            set.add(serialize((int)Math.pow(2, i)));
        } 
        String s = serialize(N);
        if(set.contains(s)){
            return true;
        }
        return false;
    }
    private String serialize(int n){
        int[] count = new int[10];
        String s = String.valueOf(n);
        for(int i=0; i<s.length(); ++i){
            count[s.charAt(i)-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<10; ++i){
            sb.append(count[i]);
        }
        return sb.toString();
    }
}

public class ReorderedPowerNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.reorderedPowerOf2(Integer.parseInt(args[0])));
	}
}
