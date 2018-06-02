//Leetcode problem 385 Mini Parser
//Solution written by Xuqiang Fang on 1 June, 2018
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

class NestedInteger{
    // Constructor initializes an empty nested list.
    public NestedInteger(){
    
    }
    // Constructor initializes a single integer.
    public NestedInteger(int value){
    
    }
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger(){
        return false; 
    }
    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger(){
        return 0; 
    }
    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value){
    
    }
    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni){
        
    }
    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList(){
        return null; 
    }
}
class Solution {
    public NestedInteger deserialize(String s) {
        if(s.isEmpty()){
            return null;
        }
        if(s.charAt(0) != '['){
            return new NestedInteger(Integer.parseInt(s));
        }

        Stack<NestedInteger> stack = new Stack<>();
        NestedInteger curr = null;
        int l = 0;
        for(int r=0; r<s.length(); ++r){
            char ch = s.charAt(r);
            if(ch == '['){
                if(curr != null){
                    stack.push(curr);
                }
                curr = new NestedInteger();
                l = r+1;
            }
            else if(ch == ']'){
                String num = s.substring(l, r);
                if(!num.isEmpty()){
                    curr.add(new NestedInteger(Integer.parseInt(num)));
                }
                if(!stack.isEmpty()){
                    NestedInteger pop = stack.pop();
                    pop.add(curr);
                    curr = pop;
                }
                l = r+1;
            }
            else if(ch == ','){
                if(s.charAt(r-1) != ']'){
                    String num = s.substring(l, r);
                    curr.add(new NestedInteger(Integer.parseInt(num)));
                }
                l = r+1;
            }
        }
        return curr;
    }
}

public class MiniParser{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
