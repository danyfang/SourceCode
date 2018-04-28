//Leetcode problem 677 Map Sum Pairs
//Solution written by Xuqiang Fang on 27 April, 2018 
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
class Solution{
    Map<String, Integer> map;
    Map<String, Set<String>> pre;
    public Solution(){
        map = new HashMap<>(); 
        pre = new HashMap<>();
    }

    public void insert(String key, int val){
        int n = key.length();
        map.put(key, val);
        for(int i=1; i<n; ++i){
            String subkey = key.substring(0,i);
            Set<String> set = pre.getOrDefault(subkey, null);
            if(set == null){
                set = new HashSet<>();
            }
            set.add(key);
            pre.put(subkey, set);
        }
        Set<String> set = pre.getOrDefault(key, null);
        if(set == null){
            set = new HashSet<>();
        }
        set.add(key);
        pre.put(key, set);
    }

    public int sum(String prefix){
        Set<String> set = pre.get(prefix);
        int sum = 0;
        if(set == null)
            return 0;
        for(String key : set){
            sum += map.get(key);
        }
        return sum;
    }
}

public class MapSum{
	public static void main(String[] args){
		Solution s = new Solution();
        s.insert("apple",3);
        System.out.println(s.sum("ap"));
        s.insert("app",2);
        System.out.println(s.sum("ap"));
        s.insert("apple",2);
        System.out.println(s.sum("ap"));
	}
}
