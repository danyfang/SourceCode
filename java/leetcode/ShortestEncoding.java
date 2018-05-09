//Leetcode problem 820 Short Encoding of Words
//Solution written by Xuqiang Fang on 8 May, 2018

import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.Comparator;

class Solution{
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>();
        int sum = 0;
        Arrays.sort(words, new Com());
        for(String word : words){
            if(!set.contains(word)){
                add(set, word);
                sum += word.length() + 1;
            }
        }
        return sum;
    }

    private void add(Set<String> set, String word){
        if(set.contains(word))
            return;
        int n = word.length();
        for(int i=n-1; i>=0; --i){
            if(!set.contains(word.substring(i,n))){
                set.add(word.substring(i,n));
            }
        }
    }

    public class Com implements Comparator<String>{
        public int compare(String a, String b){
            return b.length() - a.length();
        }
    }
}

public class ShortestEncoding{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"time", "ti", "bell"};
        System.out.println(s.minimumLengthEncoding(words));
	}
}
