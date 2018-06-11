//Leetcode problem 223 Rectangle Area
//Leetcode Problem No 850 Rectangle Area II
//Solution written by Xuqiang Fang on 23 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H){
        int areaA = (C-A) * (D-B);
        int areaB = (G-E) * (H-F);
        if(C <= E || G <= A || H <= B || D <= F) 
            return areaA + areaB;

        int width = interval(A,C,E,G);
        int height = interval(B,D,F,H);

        return areaA+areaB - width * height;
    }	

    public int interval(int l1, int r1, int l2, int r2){
        if(l1 >= l2 && r1 <= r2)
            return r1-l1;
        else if(l1 <= l2 && r1 >= r2)
            return r2-l2;
        else if(l1 <= l2 && r1 >= l2)
            return r1-l2;
        else
            return r2-l1;
    }
    //No 850
    public int rectangleArea(int[][] rec) {
        int mod = 1000000000+7;
        Map<Integer, Integer> map = new TreeMap<>();
        for(int[] r : rec){
            map.put(r[0], r[0]);
            map.put(r[2], r[2]);
        }
        int index = 0;
        for(int k : map.keySet()){
            map.put(k, index++);
        }
        List<Integer> x = new ArrayList<>(map.keySet());
        int n = x.size();
        int[] count = new int[n];
        List<int[]> L = new ArrayList<>();
        for(int[] r : rec){
            int x1 = r[0], y1 = r[1], x2 = r[2], y2 = r[3];
            L.add(new int[]{y1, x1, x2, 1});
            L.add(new int[]{y2, x1, x2, -1});
        }
        L.sort((a,b)->(a[0]-b[0]));
        long cur_y = 0, cur_x_sum = 0, area = 0;
        for(int[] l : L){
            int y = l[0], x1 = l[1], x2 = l[2];
            int sig = l[3];
            area = (area + (long)(y - cur_y) * (long)(cur_x_sum));
            area %= mod;
            cur_y = y;
            for(int i=map.get(x1); i<map.get(x2); ++i){
                count[i] += sig;
            }
            cur_x_sum = 0;
            for(int i=0; i<n; ++i){
                if(count[i] > 0){
                    cur_x_sum += x.get(i+1) - x.get(i);
                }
            }
        }
        return (int)area;
    }
}

public class RectangleArea{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.computeArea(-3,0,3,4,0,-1,9,2));
        //System.out.println(s.computeArea(-3,0,3,4,0,-1,9,2));
        int[][] rec = {{0,0,2,2},{1,0,2,3},{1,0,3,1}}; 
        System.out.println(s.rectangleArea(rec));
        int[][] rec2 = {{0,0,1000000000,1000000000}};
        System.out.println(s.rectangleArea(rec2));
	}
}
