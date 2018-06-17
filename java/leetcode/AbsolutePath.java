//Leetcode problem 388 Longest Absolute File Path
//Solution written by Xuqiang Fang on 15 June, 2018
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
    public int lengthLongestPath(String input) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;
        for(String s : input.split("\n")){
            //System.out.println(s);
            int lev = s.lastIndexOf("\t")+1;
            //System.out.println(lev);
            while(lev+1 < stack.size()){
                stack.pop();
            }
            int len = stack.peek() + s.length() -lev + 1;
            stack.push(len);
            if(s.contains(".")){
                max = Math.max(max, len-1);
            }
        } 
        return max;
    }
}

public class AbsolutePath{
	public static void main(String[] args){
		Solution s = new Solution();
        String input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        System.out.println(s.lengthLongestPath(input));
        String input2 = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";
        System.out.println(s.lengthLongestPath(input2));
	}
}
