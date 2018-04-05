//Leetcode problem 438 Find All Anagrams in a String
//Solution written by Xuqiang Fang on 20 March 2018 
/*
Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
*/
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class Solution{
	public List<Integer> findAnagrams(String s, String p) {
       	int n = p.length(); 
		List<Integer> list = new ArrayList<Integer>();
		if(s.length() < n){
			return list;
		}
		for(int i=0; i<=s.length()-n; i++){
			if(isAnagram(s.substring(i,i+n), p)){
				list.add(i);
			}
		}
		return list;
    }	
	public boolean isAnagram(String s, String p){
		int[] count = new int[26];
		for(char c : s.toCharArray()){
			count[c-'a']++;
		}
		for(char c : p.toCharArray()){
			count[c-'a']--;
		}
		for(int i : count){
			if(i != 0){
				return false;
			}
		}
		return true;
	}
}

public class AnagramString{
	public static void main(String[] args){
		Solution s = new Solution();
		String str = "cbaebabacd";
		String p = "abc";
		System.out.println(s.findAnagrams(str,p));
		System.out.println(s.findAnagrams("ba","ab"));
	}
}
