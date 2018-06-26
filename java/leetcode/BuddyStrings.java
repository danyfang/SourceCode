//Leetcode problem 859 Buddy Strings
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
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length()){
            return false;
        }
        else{
            int n = A.length();
            int[] countA = new int[26];
            int[] countB = new int[26];
            int c = 0;
            for(int i=0; i<n; ++i){
                if(A.charAt(i) != B.charAt(i)){
                    c++;
                } 
                countA[A.charAt(i)-'a']++;
                countB[B.charAt(i)-'a']++;
            }
            if(c == 2){
                for(int i=0; i<26; ++i){
                    if(countA[i]-countB[i] != 0){
                        return false;
                    }
                }
                return true; 
            }
            else if(c == 0){
                for(int j : countA){
                    if(j >= 2){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}

public class BuddyStrings{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.buddyStrings("ab","ba"));
        System.out.println(s.buddyStrings("ab","ab"));
        System.out.println(s.buddyStrings("aa","aa"));
        System.out.println(s.buddyStrings("aaaaaaabc","aaaaaaacb"));
        System.out.println(s.buddyStrings("","aa"));
	}
}
