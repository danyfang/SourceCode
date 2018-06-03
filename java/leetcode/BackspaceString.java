//Leetcode problem 844 Backspace String Compare
//Solution written by Xuqiang Fang on 3 June, 2018
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
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> s = new Stack<>();    
        Stack<Character> t = new Stack<>();    
        for(int i=0; i<S.length(); ++i){
            if(S.charAt(i) == '#'){
                if(s.size() > 0){
                    s.pop();
                }
            }
            else{
                s.push(S.charAt(i));
            }
        }
        for(int i=0; i<T.length(); ++i){
            if(T.charAt(i) == '#'){
                if(t.size() > 0){
                    t.pop();
                }
            }
            else{
                t.push(T.charAt(i));
            }
        }
        return s.toString().equals(t.toString());
    }
}

public class BackspaceString{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "ab#c";
        String T = "ad#c";
        System.out.println(s.backspaceCompare(S, T));
        System.out.println(s.backspaceCompare("a#c", "b"));
	}
}
