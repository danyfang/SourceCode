//Leetcode problem 754 Reach a Number
//Solution written by Xuqiang Fang on 14 June, 2018 
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
    /*
    * think it as ?1?2?3?4?5?6... each ? can be a - or + sign, then we want to see if there is a combination
    * of - and + such that the sum is the target
    * so this question for the -target case is just the same as +target case
    */
    public int reachNumber(int target) {
        target = Math.abs(target);
        int s = 0;
        int i = 1;
        while(s < target){
            s += i++; 
        }
        if(s == target || (s-target)%2 == 0){
            return i-1;
        }
        else if((i-1) % 2 == 0){
            return i;
        }
        return i+1;
    }
}

public class ReachNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.reachNumber(Integer.parseInt(args[0])));
	}
}
