//Leetcode problem 387 First Unique Character in a String
//Solution written by Xuqiang Fang on 20 April, 2018 
import java.util.Map;
import java.util.HashMap;
class Solution{
    public int firstUniqChar(String s){
        if(s == null || s.length() == 0)
            return -1;
        if(s.length() == 1)
            return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length(); i++){
            if(map.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }	
}

public class FirstUniqueCharacter{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.firstUniqChar(args[0]));
	}
}
