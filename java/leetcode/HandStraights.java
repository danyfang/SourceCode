//Leetcode problem 846 Hand of Straights
//Solution written by Xuqiang Fang on 3 June, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
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
    public boolean isNStraightHand(int[] hand, int W) {
        int n = hand.length;
        if(n % W != 0){
            return false;
        }
        //everytime count from the smallest
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int m = hand[0];
        for(int h : hand){
            map.put(h, map.getOrDefault(h,0)+1);
            m = Math.min(m, h);
        }
        int k = m;
        //debug
        /*
        for(int i : map.keySet()){
            System.out.println("key = " + i + " value = " + map.get(i));
        }
        */
        for(int i=0; i<n/W; ++i){
            int j=0;
            k += W;
            while(j < W){
                //System.out.println("m+j = " + (m+j) + " value = " + map.get(m+j));
                if(!map.containsKey(m+j) || map.get(m+j) == 0){
                    return false;
                }
                map.put(m+j, map.get(m+j)-1);
                if(map.get(m+j) > 0){
                    k = Math.min(k, m+j);
                }
                j++;
            }
            if(!map.containsKey(k) && map.higherKey(k) != null){
                k = map.higherKey(k);
            }
            m = k;
        }
        return true;
    }
}

public class HandStraights{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] hand = {1,2,3,6,2,3,4,7,8,1000001,1000002,1000003};
        System.out.println(s.isNStraightHand(hand, 3));
	}
}
