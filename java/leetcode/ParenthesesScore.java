//Leetcode problem 856 Score of Parentheses
//Solution written by Xuqiang Fang on 24 June, 2018
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
    public int scoreOfParentheses(String S) {
        /*2 <= S.length() <=50*/
        List<String> list = new ArrayList<>();
        int p = 0;
        int t = 0;
        for(int i=0; i<S.length(); ++i){
            if(S.charAt(i) == '('){
                t++;
            } 
            else{
                t--;
            }
            if(t == 0){
                list.add(S.substring(p,i+1));
                p = i + 1;
            }
        }
        return helper(list);
    }
    private int helper(List<String> l){
        int ans = 0;
        for(String s : l){
            if(s.equals("()")){
                ans += 1;
            } 
            else{
                ans += 2 * scoreOfParentheses(s.substring(1, s.length()-1));
            }
        }
        return ans;
    }
}

public class ParenthesesScore{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.scoreOfParentheses("()"));
        System.out.println(s.scoreOfParentheses("(())"));
        System.out.println(s.scoreOfParentheses("()()"));
        System.out.println(s.scoreOfParentheses("(()(()))"));
	}
}
