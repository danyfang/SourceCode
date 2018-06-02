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
interface NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger();

    // Constructor initializes a single integer.
    public NestedInteger(int value);

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
class Solution{
    public NestedInteger deserialize(String s) {
            
    }
}

public class MiniParser{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
