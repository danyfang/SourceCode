//Leetcode problem 500 Keyboard Row
//Solution written by Xuqiang Fang on 27 April, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
class Solution{
    public String[] findWords(String[] words){
        if(words == null || words.length == 0)
            return words;

        char[] first = {'q','w','e','r','t','y','u','i','o','p'};
        char[] second = {'a','s','d','f','g','h','j','k','l'};
        char[] third = {'z','x','c','v','b','n','m'};
        Map<Character, Integer> map = new HashMap<>();
        for(char c : first){
            map.put(c, 1);
        }
        for(char c : second){
            map.put(c, 2);
        }
        for(char c : third){
            map.put(c, 3);
        }
        List<String> list = new ArrayList<>();
        for(String word : words){
            if(sameRow(map, word)){
                list.add(word);
            }
        }
        String[] ret = new String[list.size()];
        for(int i=0; i<list.size(); ++i){
            ret[i] = list.get(i);
        }
        return ret;
    }	
    public boolean sameRow(Map<Character, Integer> map, String word){
        int row = map.get(Character.toLowerCase(word.charAt(0)));
        for(char c : word.toCharArray()){
            if(row != map.get(Character.toLowerCase(c))){
                return false;
            }
        }
        return true;
    }
}

public class KeyboardRow{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] re = s.findWords(words);
        for(String t : re){
            System.out.println(t);
        }
	}
}
