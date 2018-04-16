//Leetcode problem No 290 Word Pattern
//Solution written by Xuqiang Fang on 14 April, 2018 
import java.util.HashMap;
import java.util.Map;
class Solution{
    public boolean wordPattern(String pattern, String str){
        String[] array = str.split("\\s");
        char[] ch = pattern.toCharArray();
        if(array.length != ch.length)
            return false;
        Map<Character, String> map = new HashMap<>();
        for(int i=0; i<ch.length; i++){
            if(!map.containsKey(ch[i])){
                //This is the key part
                if(map.containsValue(array[i]))
                    return false;
                map.put(ch[i], array[i]); 
                continue;
            }
            if(!map.get(ch[i]).equals(array[i]))
                return false;
        }
        return true;
    }	
}

public class WordPattern{
	public static void main(String[] args){
		Solution s = new Solution();
        String a = "abba";
        String as = "dog cat cat dog";
        String bs = "dog cat cat fish";
        String cs = "dog dog dog dog";
        String b = "aaaa";

        System.out.println(s.wordPattern(a, as));
        System.out.println(s.wordPattern(a, cs));
        System.out.println(s.wordPattern(a, bs));
        System.out.println(s.wordPattern(b, as));
	}
}
