//Leetcode problem 139 Word Break
//Solution written by Xuqiang Fang on 06 March 2018 
/*
Given a dictionary and string, determine if the string is composed of 
all words from the dictionary!
*/
//Solution using dynamic programming, accepted!

import java.util.List;
import java.util.ArrayList;

class Solution{
	public boolean wordBreak(String s, List<String> wordDict){
		boolean[] wb = new boolean[s.length()+1];
		for(int i=1; i<=s.length(); i++){
			if(wb[i] == false && wordDict.contains(s.substring(0,i)))
				wb[i] = true;
			if(wb[i] == true){
				if(i == s.length())
					return true;
				for(int j=i+1; j<=s.length(); j++){
					if(wb[j] == false && wordDict.contains(s.substring(i,j)))
						wb[j] = true;
					if(j == s.length() && wb[j] == true)
						return true;
				}
			}
		}
		return false;
	}
}

public class WordBreak{
	public static void main(String[] args){
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		String ss = "leetleeetcode";
		System.out.println(s.wordBreak(ss, wordDict));
	}
}
