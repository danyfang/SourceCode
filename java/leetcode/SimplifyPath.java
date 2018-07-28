//Leetcode problem 71 Simplify Path
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
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        stack.push("/");
        String[] paths = path.split("/");   
        for(String s : paths){
            if(s.length() > 0){
                if(s.equals(".")){
                    continue;
                }
                else if(s.equals("..")){
                    if(stack.size() > 1){
                        stack.pop();
                    }
                }
                else{
                    stack.push(s);
                }
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(stack.size() > 1){
            ans.insert(0, "/" + stack.pop());
        }
        if(ans.length() == 0){
            return "/";
        }
        return ans.toString();
    }
}

public class SimplifyPath{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.simplifyPath(args[0]));
	}
}

// input "/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"
// output "/e/f/g"
