//Leetcode problem 139 Word Break
//Leetcode problem 140 Word Break II
//Solution written by Xuqiang Fang on 06 March 2018 
/*
Given a dictionary and string, determine if the string is composed of 
all words from the dictionary!
*/
//Solution using dynamic programming, accepted!

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

class Solution{
    //solutioin for word break 139
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
    
    //solution for word break II 140
    public List<String> wordBreak_(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>();
        dict.addAll(wordDict);
        Map<String, List<String>> m = new HashMap<>();
        return helper(s, dict, m);
    }
    private List<String> helper(String s, Set<String> d, Map<String, List<String>> m){
        if(m.containsKey(s)){
            return m.get(s);
        }
        List<String> ans = new ArrayList<>();
        if(d.contains(s)){
            ans.add(s);
        }

        for(int i=1; i<s.length(); ++i){
            String right = s.substring(i);
            if(!d.contains(right)){
                continue;
            }
            String left = s.substring(0,i);
            List<String> left_ans = append(helper(left, d, m), right);
            ans.addAll(left_ans);
        }
        m.put(s, ans);
        return ans;
    }

    private List<String> append(List<String> p, String w){
        List<String> ans = new ArrayList<>();
        for(String q : p){
            ans.add(q + " " + w);
        }
        return ans;
    }
}

public class WordBreak{
	public static void main(String[] args){
		Solution s = new Solution();
		List<String> wordDict = new ArrayList<String>();
		wordDict.add("leet");
		wordDict.add("code");
		String ss = "leetcode";
		System.out.println(s.wordBreak_(ss, wordDict));
	}
}
