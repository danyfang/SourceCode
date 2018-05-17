//Leetcode problem 636 Exclusive Time of Functions
//Solution written by Xuqiang Fang on 15 May, 2018

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution{
    //store the id, not timestamp
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];        
        if(logs == null || logs.size() == 0)
            return ans;
        
        Stack<Integer> stack = new Stack<>();
        int prev = 0;
        for(String log : logs){
            String[] l = log.split(":");
            if(!stack.isEmpty())
                ans[stack.peek()] += Integer.parseInt(l[2]) - prev;
            prev = Integer.parseInt(l[2]);
            if(l[1].equals("start")){
                stack.push(Integer.parseInt(l[0]));
            }
            else{
                ans[stack.pop()]++;
                prev++;
            }
        }

        return ans;
    }
}

public class ExclusiveTime{
	public static void main(String[] args){
		Solution s = new Solution();
        List<String> logs = Arrays.asList("2:start:0","1:start:2","1:end:5","2:end:6");
        int[] res = s.exclusiveTime(3, logs);
        for(int i : res){
            System.out.println(i);
        }
	}
}
