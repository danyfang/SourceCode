//Leetcode problem 205 Isomorphic Strings
//Solution written by Xuqiang Fang on 13 April, 2018 
import java.util.HashMap;
class Solution{
    public boolean isIsomorphic(String s, String t){
        if(s.equals(t))
            return true;
        if(s.length() != t.length())
            return false;
        HashMap<Character, Character> map = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            char sc = s.charAt(i);//key
            char tc = t.charAt(i);//value
            if(!map.containsKey(sc)){
                if(map.containsValue(tc))// no two char can be mapped to the same value
                    return false;
                map.put(sc, tc);
            }
            if(map.get(sc) != tc  )
                return false;
        }
        return true;
    }	
}

public class IsomorphicStrings{
	public static void main(String[] args){
		Solution s = new Solution();
        /*
        ab ca true
        ab aa false
        */
        System.out.println(s.isIsomorphic(args[0],args[1]));
	}
}
