//Leetcode problem 218 The Skyline Problem
//Solution written by Xuqiang Fang on 12 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.TreeMap;
import java.util.Collections;
class Solution{
    public List<int[]> getSkyline(int[][] buildings){
        //sweep line 
        List<int[]> h = new ArrayList<>();
        for(int[] b : buildings){
            h.add(new int[]{b[0],-b[2]}); 
            h.add(new int[]{b[1],b[2]}); 
        }
        Collections.sort(h, (a,b)->{
            if(a[0] == b[0]){
                return a[1] - b[1];
            } 
            return a[0] - b[0];
        });
        /*
        for(int[] a : h){
            System.out.println(a[0] + "," + a[1]);
        }
        */
        Queue<Integer> q = new PriorityQueue<>((a,b)->(b-a));
        q.offer(0);
        int p = 0;
        List<int[]> ans = new ArrayList<>();
        for(int[] s : h){
            if(s[1] < 0){
                q.offer(-s[1]); 
            }
            else{
                q.remove(s[1]);
            }
            int c = q.peek();
            if(p != c){
                ans.add(new int[]{s[0], c});
                p = c;
            }
        }
        //System.out.println(q.peek());
        return ans;
    }
}

public class SkylineProblem{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] buildings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{10,24,8}};
        List<int[]> ans;
        /*
        ans = s.getSkyline(buildings);
        for(int[] a : ans){
            System.out.println(a[0] + "," +  a[1]);
        }
        */
        buildings = new int[][]{{1,2,3},{1,2,4},{1,2,5},{1,2,6},{4,6,9}};
        /*
        ans = s.getSkyline(buildings);
        for(int[] a : ans){
            System.out.println(a[0] + "," +  a[1]);
        }
        */
        buildings = new int[][]{{0,2,3},{2,5,3}};
        ans = s.getSkyline(buildings);
        for(int[] a : ans){
            System.out.println(a[0] + "," +  a[1]);
        }
	}
}
