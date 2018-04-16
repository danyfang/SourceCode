//Leetcode problem 819 Most Common Word
//Solution written by Xuqiang Fang on 15 April, 2018 
import java.util.HashMap;
import java.util.Map;
class Solution{
    public String mostCommonWord(String paragraph, String[] banned) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> ban = new HashMap<>();
        String[] words = paragraph.split("[\\p{Punct}\\s]+");
        for(String w : banned){
            ban.put(w,1);
        } 
        int maxCount = 0;
        String result = "";
        for(String w : words){
            w = w.toLowerCase();
            if(ban.containsKey(w)){
                continue;
            }
            int count = map.getOrDefault(w, 0);
            map.put(w, count + 1);
            if(count + 1 > maxCount){
                result = w;
                maxCount = count + 1;
            }
        }
        return result.toLowerCase();
    }	
}

public class CommonWord{
	public static void main(String[] args){
		Solution s = new Solution();
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit. but anyway this is great this is going to be is is is";
        String[] banned = {"hit"};
        System.out.println(s.mostCommonWord(paragraph, banned));
	}
}
