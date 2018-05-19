//Leetcode problem 756 Pyramid Transition Matrix
//Solution written by Xuqiang Fang on 19 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
class Solution{
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        Map<String, List<Character>> map = new HashMap<>();
        for(String a : allowed){
            String key = a.substring(0,2);
            if(!map.containsKey(key)){
                List<Character> temp = new ArrayList<>();
                map.put(key, temp);
            }
            map.get(key).add(a.charAt(2));
        }
        return recursion(bottom, map);
    }

    private boolean recursion(String bottom, Map<String, List<Character>> map){
        if(bottom.length() == 2){
            if(map.containsKey(bottom)){
                return true;
            }
            return false;
        }
        List<String> next = new ArrayList<>();
        String[] nextKey = new String[bottom.length()-1];
        for(int i=0; i<=bottom.length()-2; ++i){
            String key = bottom.substring(i, i+2); 
            if(!map.containsKey(key)){
                return false;
            }
            nextKey[i] = key;
        }
        //now construct all possible bottoms for next recursion
        construct(nextKey, map, next, new StringBuilder(), 0);
        for(String n : next){
            if(recursion(n, map)){
                return true;
            }
        }
        return false;
    }

    private void construct(String[] key, Map<String, List<Character>> map, List<String> next, StringBuilder temp, int index){
        if(temp.length() == key.length){
            //System.out.println(temp.toString());
            next.add(temp.toString());
            return;
        }  
        for(int i=index; i<key.length; ++i){
            for(char value : map.get(key[i])){
                temp.append(value);
                construct(key, map, next, temp, i+1);
                temp.deleteCharAt(temp.length()-1);
            }
        }
    }


}

public class PyramidMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
        List<String> l = Arrays.asList("XYD", "YZE", "DEA", "FFF");
        System.out.println(s.pyramidTransition("XYZ", l));
	}
}
