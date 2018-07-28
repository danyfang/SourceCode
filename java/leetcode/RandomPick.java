//Leetcode problem 880 Random Pick with Weight
//Solution written by Xuqiang Fang on 28 July, 2018
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
import java.util.Random;
class Solution{
    Random r;
    int M;
    TreeMap<Integer, Integer> map = new TreeMap<>();
    public Solution(int[] w) {
        r = new Random(); 
        int s = 0;
        for(int i=0; i<w.length; ++i){
            s += w[i];
            map.put(s, i);
        }
        M = s;
    }
    
    public int pickIndex() {
        int key = map.higherKey(r.nextInt(M));
        return map.get(key);
    }
}

public class RandomPick{
	public static void main(String[] args){
        int[] num = {1,3};
		Solution s = new Solution(num);
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
        System.out.println(s.pickIndex());
	}
}
