//Leetcode problem  678 Valid Parenthesis String 
//Solution written by Xuqiang Fang on 30 May, 2018
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
    boolean checkValidString(String s){
        int l = 0;
        int h = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) == '('){
                l++;
                h++;
            }
            else if(s.charAt(i) == ')'){
                if(l > 0){
                    l--;
                }
                h--;
            }
            else{
                if(l > 0){
                    l--;
                }
                h++;
            }
            if(h < 0){
                return false;
            }
        }
        return l == 0;
    }
}

public class ValidParenthesis{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.checkValidString("**(((((())"));
        System.out.println(s.checkValidString("(((****(((*))"));
	}
}
