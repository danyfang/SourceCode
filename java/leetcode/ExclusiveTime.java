//Leetcode problem 636 Exclusive Time of Functions
//Solution written by Xuqiang Fang on 15 May, 2018

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution{
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];        
        if(logs == null || logs.size() == 0)
            return ans;
        
        Stack<Integer> stack = new Stack<>();
        int buildup = 0;
        for(String log : logs){
            String[] l = log.split(":");
            if(l[1].equals("start")){
                stack.push(Integer.valueOf(l[2])); 
            }
            else{
                int time = Integer.valueOf(l[2]);
                int id = Integer.valueOf(l[0]);
                ans[id] = time + 1 - stack.pop() - buildup; 
                buildup += ans[id];
            }
            if(stack.isEmpty()){
                buildup = 0;
            }
        }

        return ans;
    }
}

public class ExclusiveTime{
	public static void main(String[] args){
		Solution s = new Solution();
        List<String> logs = Arrays.asList("2:start:0","1:start:2","1:end:5","2:end:6","0:start:7","0:end:19");
        int[] res = s.exclusiveTime(3, logs);
        for(int i : res){
            System.out.println(i);
        }
	}
}
