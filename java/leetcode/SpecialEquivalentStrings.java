//Leetcode problem 893 Groups of Special Equivalent Strings
//Solution written by Xuqiang Fang on 17 Aug, 2018
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
    public int numSpecialEquivGroups(String[] A) {
        int n = A.length;
        int[] flag = new int[n];
        int index = 0;
        for(int i=0; i<n; ++i){
            if(flag[i] == 0){
                index++;
                flag[i] = index;
                for(int j=i+1; j<n; ++j){
                    if(special(A[i], A[j])){
                        flag[j] = index;
                    }
                }
            }
        }
        /*
        for(int f : flag){
            System.out.print(f+" ");
        }
        System.out.println("");
        */
        return index;
    }
    public boolean special(String a, String b){
        if(part(a, 0).equals(part(b, 0)) && part(a, 1).equals(part(b, 1))){
            return true;
        }
        return false;
    }
    public String part(String a, int m){
        int[] count = new int[26];
        for(int i=m; i<a.length(); i+=2){
            count[a.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; ++i){
            sb.append(count[i]);
        }
        return sb.toString();
    }
}

public class SpecialEquivalentStrings{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] A = {"a","b","c","a","c","c"};
        /*
        System.out.println(s.part("abc", 0));
        System.out.println(s.part("abc", 1));
        System.out.println(s.special("abc", "cba"));
        */
        System.out.println(s.numSpecialEquivGroups(A));
        A = new String[]{"abc","acb","bac","bca","cab","cba"};
        System.out.println(s.numSpecialEquivGroups(A));
        A = new String[]{"abcd","cdab","adcb","cbad"};
        System.out.println(s.numSpecialEquivGroups(A));
	}
}
