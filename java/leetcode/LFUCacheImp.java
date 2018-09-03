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
    Map<Integer, LinkedHashSet<Integer>> cache;
    int capa;
    public LFUCache(int capacity) {
        capa = capacity; 
        map = new HashMap<>();
        cache = new HashMap<>();
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
        if(!map.containsKey(key)){
            if(map.size() < capa){
                map.put(key, map.getOrDefault(key, 0)+1); 
            } 
            else{
            
            }
        }
        else{
            //already contains the key

        }
    }
}
public class LFUCacheImp{
	public static void main(String[] args){
		LFUCache s = new LFUCache(3);
	}
}
