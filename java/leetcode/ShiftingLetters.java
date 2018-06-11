//Leetcode problem 848 Shifting Letters
//Solution written by Xuqiang Fang on 10 June, 2018
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
    public String shiftingLetters(String S, int[] shifts) {
        int n = S.length();
        long[] sum = new long[n];
        sum[n-1] = (long)shifts[n-1];
        for(int i=n-2; i>=0; --i){
            sum[i] = sum[i+1]+(long)shifts[i];
        }
        StringBuilder sb = new StringBuilder(S);
        for(int i=0; i<n; ++i){
            char c = (char)((sb.charAt(i)-'a'+sum[i]%26)%26+'a');
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
}

public class ShiftingLetters{
	public static void main(String[] args){
		Solution s = new Solution();
        String S = "abc";
        int[] shifts = {3,5,9};
        String S2 = "mkgfzkkuxownxvfvxasy";
        int[] shifts2 = {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513};
        //System.out.println(s.shiftingLetters(S, shifts));
        System.out.println(s.shiftingLetters(S2, shifts2));
	}
}
