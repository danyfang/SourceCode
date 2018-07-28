//Leetcode problem 420 Strong Password Checker
//Solution written by Xuqiang Fang on 27 July, 2018
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
    public int strongPasswordChecker(String s) {
        //for string with length less than 20, it is the max of three checkers
        //for string with length bigger than 20, remove consecutive ones and apply normal checker
        if(s.length() <= 20){
            return normal(s);
        }
        return abnormal(s);
    }
    private int normal(String s){
        int ans = 0;
        if(s.length() < 6){
            ans = Math.max(ans, 6-s.length());
        }
        int u = 0, l = 0, d = 0;
        for(int i=0; i<s.length(); ++i){
            if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z'){ u++; }
            else if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){ d++; }
            else if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){ l++; }
        }
        int t = 0;
        if(u == 0){ t++; }
        if(l == 0){ t++; }
        if(d == 0){ t++; }
        ans = Math.max(ans, t);
        t = 0;
        for(int i=0; i<s.length(); ){
            int j = i+1;
            while(j < s.length() && s.charAt(j) == s.charAt(i)){
                ++j;
            }
            if(j-i >= 3){
                t += (j-i) / 3;
            }
            i = j;
        }
        ans = Math.max(ans, t);
        return ans;
    }
    private int abnormal(String s){
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        List<int[]> list = new ArrayList<>();
        int total = 0;
        for(int i=0; i<n-1; ){
            int j = i+1; 
            while(j < n && s.charAt(j) == s.charAt(i)){
                j++;
            }
            if(j-i >= 3){
                list.add(new int[]{i, j});
                total += j-i;
                /**
                int t = sb.length() + n-j;
                if(t <= 20){
                    sb.append(s.substring(i, i+20-t));
                    sb.append(s.substring(j));
                    return n-20+normal(sb.toString());
                }
                */
            }
            else{
                sb.append(s.substring(i, j));
            }
            i = j;
            if(i == n-1){
                sb.append(s.charAt(i));
            }
        }
        int min = Integer.MAX_VALUE;
        //System.out.println(sb.toString());
        for(int i=0; i<=sb.length()-20; ++i){
            min = Math.min(min, n-20+normal(sb.substring(i, i+20))); 
        }
        return min;
    }
}

public class PasswordChecker{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.strongPasswordChecker("ababababababababababaaa"));//5
        System.out.println(s.strongPasswordChecker("1234567890123456Baaaaa"));//3
        System.out.println(s.strongPasswordChecker("1010101010aaaB10101010"));//2
        System.out.println(s.strongPasswordChecker("ABABABABABABABABABAB1"));//2
        System.out.println(s.strongPasswordChecker("aaaaaaaaaaaaaaaaaaaaa"));//7
        System.out.println(s.strongPasswordChecker("aaaabbaaabbaaa123456A"));//3
	}
}
