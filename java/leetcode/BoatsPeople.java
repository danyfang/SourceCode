//Leetcode problem 885 Boats to Save People
//Solution written by Xuqiang Fang on 5 Aug 2018
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public int numRescueBoats(int[] people, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();    
        for(int p : people){
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        int ans = 0;
        while(map.size() > 0){
            int key = map.lastKey();
            ans++;
            map.put(key, map.get(key)-1);
            if(map.get(key) == 0){
                map.remove(key);
            }
            int pair = limit - key;
            if(map.floorKey(pair) != null){
                int k = map.floorKey(pair);
                map.put(k, map.get(k)-1);
                if(map.get(k) == 0){
                    map.remove(k);
                }
            }
        }
        return ans;
    }
}

public class BoatsPeople{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] people = {3,2,2,1};
        System.out.println(s.numRescueBoats(people, 3));
        people = new int[]{3,5,3,4};
        System.out.println(s.numRescueBoats(people, 5));
	}
}
