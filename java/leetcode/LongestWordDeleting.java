//Leetcode problem  524 Longest Word in Dictionary through Deleting
//Solution written by Xuqiang Fang on 12 May, 2018

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution{
    public String findLongestWord(String s, List<String> d) {
        char[] unit = s.toCharArray(); 
        String res = "";
        for(String t : d){
            if(contain(unit, t)){
                if(t.length() > res.length() || (t.length() == res.length() && t.compareTo(res) < 0)){
                    res = t;
                }
            }
        }  
        return res;
    }

    private boolean contain(char[] unit, String s){
        char[] test = s.toCharArray();
        int l = 0;
        int r = 0;
        while(l < unit.length && r < test.length){
            if(unit[l] == test[r]){
                ++l;
                ++r;
            } 
            else{
                ++l;
            }
        }
        if(r == test.length)
            return true;
        return false;
    }
}

public class LongestWordDeleting{
	public static void main(String[] args){
		Solution s = new Solution();
        List<String> dict = Arrays.asList("ale","apple","monkey","plea");
        String S = "abpcplea";
        String S2 = "aewfafwafjlwajflwajflwafj";
        List<String> dict2 = Arrays.asList("apple","ewaf","awefawfwaf","awef","awefe","ewafeffewafewf");
        System.out.println(s.findLongestWord(S, dict));
        System.out.println(s.findLongestWord(S2, dict2));
	}
}
