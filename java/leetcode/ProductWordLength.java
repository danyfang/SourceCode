//Leetcode problem 318 Maximum Product of Word Lengths
//Solution written by Xuqiang Fang on 18 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
class Solution{
    public int maxProduct(String[] words){
        int max = 0;
        if(words == null || words.length <= 0)
            return max;

        int[] length = new int[words.length];
        for(int i=0; i<words.length; i++){
            int[] ch = new int[26];
            for(char c : words[i].toCharArray()){
                ch[c-'a'] = 1;
            }
            StringBuilder s = new StringBuilder();
            for(int num : ch)
                s.append(num);
            //System.out.println(s.toString());
            length[i] = Integer.parseInt(s.toString(),2);
        }

        for(int i=0; i<words.length; i++){
            for(int j=i+1; j<words.length; j++){
                if((length[i] & length[j]) == 0)
                    max = Math.max(max, words[i].length() * words[j].length());
            }
        }
        return max;
    }	
}

public class ProductWordLength{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        String[] words2 = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
        String[] words3 = {"a", "aa", "aaa", "aaaa"};
        System.out.println(s.maxProduct(words));
        System.out.println(s.maxProduct(words2));
        System.out.println(s.maxProduct(words3));
	}
}
