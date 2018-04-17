//Leetcode problem 299 Bulls and Cows
//Solution written by Xuqiang Fang on 17 April, 2018 
import java.util.HashMap;
import java.util.Map;
class Solution{
    public String getHint(String secret, String guess){
        //the lengths are always equal
        if(secret == null || guess == null || secret.length() == 0 || guess.length() == 0)
            return "";
        Map<Character, Integer> map = new HashMap<>();
        int bull = 0;
        int cow = 0;
        char c;
        for(int i=0; i<secret.length(); i++){
            c = secret.charAt(i);
            if(c == guess.charAt(i))
                bull++;
            else
                map.put(c, map.getOrDefault(c, 0)+1);
        } 
        for(int i=0; i<guess.length(); i++){
            c = guess.charAt(i);
            if(c != secret.charAt(i) && map.containsKey(c) && map.get(c) > 0){
                cow++;
                map.put(c, map.get(c)-1);
            }
        }
        return bull+"A"+cow+"B";
    }	
}

public class BullsCows{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.getHint(args[0], args[1]));
	}
}
