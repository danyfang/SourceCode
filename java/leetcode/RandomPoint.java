//Leetcode problem 882 Random Point in Non-overlapping Rectangles
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
import java.util.Random;
class Solution{
    TreeMap<Integer, Integer> map;
    int index;
    int[][] ref;
    Random r;
    public Solution(int[][] rects) {
        map = new TreeMap<>();
        ref = rects;
        r = new Random();
        index = 0;
        for(int i=0; i<rects.length; ++i){
            int[] re = rects[i];
            index += (re[2]-re[0]+1) * (re[3]-re[1]+1);
            map.put(index, i);
        } 
        //System.out.println(index);
        /**
        for(int k : map.keySet()){
            System.out.println(k + "," + map.get(k));
        }
        */
    }
    
    public int[] pick() {
        int key = r.nextInt(index); 
        int i = map.get(map.higherKey(key));
        //System.out.println(i);
        int[] re = ref[i];
        int x = re[0] + r.nextInt(re[2]-re[0]+1);
        int y = re[1] + r.nextInt(re[3]-re[1]+1);
        return new int[]{x, y};
    }
}

public class RandomPoint{
	public static void main(String[] args){
        int[][] rects = {{-2,-2,-1,-1},{1,0,3,0}};
		Solution s = new Solution(rects);
        int[] ans = s.pick();
        System.out.println(ans[0] + ", " + ans[1]);
        ans = s.pick();
        System.out.println(ans[0] + ", " + ans[1]);
        ans = s.pick();
        System.out.println(ans[0] + ", " + ans[1]);
        ans = s.pick();
        System.out.println(ans[0] + ", " + ans[1]);
        ans = s.pick();
        System.out.println(ans[0] + ", " + ans[1]);
	}
}
