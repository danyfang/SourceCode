//Leetcode problem 87 Scramble String 
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
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2)){
            return true;
        }
        int n = s1.length();
        int[] count = new int[26];
        for(int i=0; i<n; ++i){
            count[s1.charAt(i)-'a']++; 
            count[s2.charAt(i)-'a']--; 
        }
        for(int i=0; i<26; ++i){
            if(count[i] != 0){
                return false;
            }
        }
        for(int i=1; i<n; ++i){
            if(isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }
            if(isScramble(s1.substring(0, i),s2.substring(n-i))&&isScramble(s1.substring(i,n),s2.substring(0,n-i))){
                return true;
            }
        }
        return false;
    }
}

public class ScrambleString{
	public static void main(String[] args){
		Solution s = new Solution();
        String s1 = "great";
        String s2 = "rgeat";
        String s3 = "rtgea";
        System.out.println(s.isScramble(s1, s2));
        System.out.println(s.isScramble(s3, s2));
        System.out.println(s.isScramble(s1, s3));
	}
}
