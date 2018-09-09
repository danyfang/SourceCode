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
    Map<Integer, Integer> vals;
    Map<Integer, Integer> counts;
    Map<Integer, LinkedHashSet<Integer>> cache;
    int cap;
    int min;
    public LFUCache(int capacity) {
        cap = capacity; 
        vals = new HashMap<>();
        counts = new HashMap<>();
        cache = new HashMap<>();
        min = -1;
        cache.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)){
            return -1;
        }
        else{
            int c = counts.get(key);
            counts.put(key, c+1);
            cache.get(c).remove(key);
            if(c == min && cache.get(c).size() == 0){
                min++;
            }
            if(!cache.containsKey(c+1)){
                cache.put(c+1, new LinkedHashSet<>());
            }
            cache.get(c+1).add(key);
            return vals.get(key);
        }
    }
    
    public void put(int key, int value) {
        if(cap <= 0){
            return;
        }
        else if(vals.containsKey(key)){
            vals.put(key, value);
            get(key);
            return;
        }
        else if(vals.size() >= cap){
            //evict the least frequent one, the freq is min
            int out = cache.get(min).iterator().next();
            cache.get(min).remove(out);
            vals.remove(out);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        cache.get(1).add(key);
    }
}
public class LFUCacheImp{
	public static void main(String[] args){
		LFUCache s = new LFUCache(3);
	}
}
