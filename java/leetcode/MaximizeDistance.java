//Leetcode problem 849 Maximize Distance to Closest Person
//Solution written by Xuqiang Fang on 10 June, 2018
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
class Solution{
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int l = 0;
        int r = 1;
        int m = 1;
        for(int i=1; i<n; ++i){
            if(seats[i] == 1){
                r = i;
                if(seats[0] == 0 && l == 0){
                    m = Math.max(m, 2*(r-l));
                }
                else{
                    m = Math.max(m, r-l);
                }
                l = r;
            }
            else if(i == n-1){
                m = Math.max(m, 2*(n-1-l));
            }
        }
        return m/2;
    }
}

public class MaximizeDistance{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] seats = {1,0,0,0,1,0,1};
        int[] seat = {1,0,0,0};
        int[] sea = {0,0,0,0,0,1};
        System.out.println(s.maxDistToClosest(seats));
        System.out.println(s.maxDistToClosest(seat));
        System.out.println(s.maxDistToClosest(sea));
	}
}
