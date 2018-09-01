//Leetcode problem 460 LFU Cache
//Solution written by Xuqiang Fang on 1 Sep, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedHashSet;
import java.util.Arrays;
class LFUCache {
    Map<Integer, Integer> map;
    LinkedHashSet<Integer> set;
    int capa;
    public LFUCache(int capacity) {
        capa = capacity; 
        map = new HashMap<>();
        set = new LinkedHashSet<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        else{
            int c = map.get(key);
            map.put(key, c+1);
        }
    }
    
    public void put(int key, int value) {
        map.put(key, map.getOrDefault(key, 0)+1); 
    }
}
public class LFUCacheImp{
	public static void main(String[] args){
		LFUCache s = new LFUCache(3);
	}
}
