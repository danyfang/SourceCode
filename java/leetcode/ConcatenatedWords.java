//Leetcode problem 472 Concatenated Words
//Solution written by Xuqiang Fang on 23 May, 2018

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution{
    public List<String> findAllConcatenatedWordsInADict(String[] words){
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return a.length() - b.length();
            }
        });
        for(String w : words){
            System.out.println(w);
        }
        Set<String> set = new HashSet<>();
        for(int i=0; i<words.length; ++i){
            if(canCon(words[i], set)){
                ans.add(words[i]);
            }
            set.add(words[i]);
        }
        return ans;
    }

    private boolean canCon(String w, Set<String> d){
        if(d.isEmpty()){
            return false;
        }
        boolean[] dp = new boolean[w.length()+1];
        dp[0] = true;
        for(int i=1; i<=w.length(); ++i){
            for(int j=0; j<i; ++j){
                if(!dp[j]){
                    continue;
                }
                if(d.contains(w.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[w.length()];
    }
}

public class ConcatenatedWords{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(s.findAllConcatenatedWordsInADict(words));
	}
}
