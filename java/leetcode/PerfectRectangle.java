//Leetcode problem 391 Perfect Rectangle
//Solution written by Xuqiang Fang on 29 Aug, 2018
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
class Solution {
    public boolean isRectangleCover(int[][] rectangles) {
        int right = Integer.MIN_VALUE;
        int up = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
        int down = Integer.MAX_VALUE;
        int s = 0;
        HashSet<String> set = new HashSet<>();
        for(int[] r : rectangles){
            s += (r[2]-r[0]) * (r[3]-r[1]);
            left = Math.min(r[0], left);
            down = Math.min(r[1], down);
            right = Math.max(r[2], right);
            up = Math.max(r[3], up);
            String x1 = r[0] + " " + r[1];
            String x2 = r[0] + " " + r[3];
            String x3 = r[2] + " " + r[1];
            String x4 = r[2] + " " + r[3]; 
            if(!set.add(x1)){
                set.remove(x1);
            }
            if(!set.add(x2)){
                set.remove(x2);
            }
            if(!set.add(x3)){
                set.remove(x3);
            }
            if(!set.add(x4)){
                set.remove(x4);
            }
        }
        if(s != (right-left)*(up-down)){
            return false;
        }
        if(!set.contains(left + " " + down) || !set.contains(left + " " + up) || 
            !set.contains(right + " " + down) || !set.contains(right + " " + up) || set.size() != 4){
                return false;
        }
        return true;
    }
    
    //a routine to check if two rectangles intersect
    private boolean intersect(int[] r1, int[] r2){
        if(r1[0] < r2[2] && r1[2] > r2[0] && r1[3] > r2[1] && r1[1] < r2[3] ){
            return true;
        }
        return false;
    }
}
public class PerfectRectangle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] rect = {{0,0,1,1},{0,1,3,2},{1,0,2,2}};
        System.out.println(s.isRectangleCover(rect));
	}
}
