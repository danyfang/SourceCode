//Leetcode problem 804 Unique Morse Code Words
//Solution written by Xuqiang Fang on 9 May, 2018

import java.util.HashSet;
import java.util.Set;
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                sb.append(morse[c-'a']);
            }
            set.add(sb.toString());
            sb.delete(0, sb.length());
        }
        
        return set.size();
    }
}

public class MorseCode{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"gin", "zen", "gig", "msg"};
        System.out.println(s.uniqueMorseRepresentations(words));
	}
}
