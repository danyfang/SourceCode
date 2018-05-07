//Leetcode problem 720 Longest Word in Dictionary
//Solution written by Xuqiang Fang on 6 May, 2018
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
class Solution{
    public String longestWord(String[] words){
        Arrays.sort(words);
        Set<String> set = new HashSet<>();
        String res = "";
        for(String w : words){
            if(w.length() == 1 || set.contains(w.substring(0,w.length()-1))){
                res = w.length() > res.length() ? w : res;
                set.add(w);
            }
        }

        return res;
    }

}

public class LongestWord{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"w","wo","wor","worl", "world"};
        String[] words2 = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(s.longestWord(words));
        System.out.println(s.longestWord(words2));
        System.out.println(Double.MAX_VALUE);
	}
}
