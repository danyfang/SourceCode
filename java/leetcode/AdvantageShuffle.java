//Leetcode problem 870 Advantage Shuffle
//Solution written by Xuqiang Fang on 15 July, 2018
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
    public int[] advantageCount(int[] A, int[] B) {
        TreeMap<Integer, Integer> map = new TreeMap<>();    
        for(int i : A){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        int[] ans = new int[A.length];
        for(int i=0; i<A.length; ++i){
            if(map.higherKey(B[i]) != null){
                ans[i] = map.higherKey(B[i]);
            }
            else{
                ans[i] = map.firstKey();
            }
            if(map.get(ans[i]) == 1){
                map.remove(ans[i]);
            }
            else{
                map.put(ans[i], map.get(ans[i])-1);
            }
        }
        return ans;
    }
}

public class AdvantageShuffle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {12,24,8,32};
        int[] B = {13,25,32,11};
        A = new int[]{2,0,4,1,2};
        B = new int[]{1,3,0,0,2};
        int[] ans = s.advantageCount(A, B);
        for(int i : ans){
            System.out.print(i + ", ");
        }
        System.out.println("");
	}
}
