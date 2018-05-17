//Leetcode problem 424 Longest Repeating Chracter Replacement
//Solution written by Xuqiang Fang on 17 May, 2018
import java.util.ArrayList;
import java.util.List;
class Solution{
    public int characterReplacement(String s, int k) {
        //this keep track of all letters within the window
        int[] letter = new int[26];    
        List<Character> queue = new ArrayList<>();
        char[] ch = s.toCharArray();
        int maxLength = 0;
        int index = 0;
        int count = 0;
        while(index < ch.length){
            while(index<ch.length&&
            (queue.size()-count < k|| queue.size()-count == k && letter[ch[index]-'A'] == count)){
                queue.add(ch[index]); 
                letter[ch[index]-'A']++;
                maxLength = Math.max(maxLength, queue.size());
                index++;
                count = maxCount(letter);
            }
            char c = queue.remove(0);
            letter[c-'A']--;
            count = maxCount(letter);
        }
        for(char c : queue){
            System.out.println("Character" + c);
        }
        return maxLength;
    }
    private int maxCount(int[] letter){
        int max = 0;
        for(int i : letter){
            max = Math.max(i, max);
        }
        return max;
    }
}

public class CharacterReplacement{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.characterReplacement("ABAB", 2));
        //System.out.println(s.characterReplacement("AABABBA", 1));
        System.out.println(s.characterReplacement("ASAAAADDFDDDDDDB", 2));
	}
}
