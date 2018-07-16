//Leetcode problem 871 Minimum Number of Refueling Stops
//Solution written by Xuqiang Fang on 15 July, 2018
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
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->(b-a));    
        int sum = startFuel;
        int ans = 0;
        for(int[] s : stations){
            while(sum < s[0]){
                if(q.isEmpty()){
                    return -1;
                }
                if(q.size() > 0){
                    System.out.println(q.peek());
                    sum += q.poll();
                    ans += 1;
                }
            }
            q.offer(s[1]);
        }
        while(sum < target){
            if(q.isEmpty()){
                return -1;
            }
            if(q.size() > 0){
                sum += q.poll();
                ans += 1;
            }
        }
        System.out.println(q.size());
        return ans;
    }
}

public class RefuelingStops{
	public static void main(String[] args){
		Solution s = new Solution();
        int target = 100;
        int startFuel = 10;
        int[][] stations = {{10, 60},{20, 30},{30, 30},{60, 40}};
        //System.out.println(s.minRefuelStops(target, startFuel, stations));
        target = 1000;
        startFuel = 83;
        stations = new int[][]{{25,27},{36,187},{140,186},{378,6},{489,202},{517,89},
        {579,234},{673,86},{808,53},{954,49}};
        System.out.println(s.minRefuelStops(target, startFuel, stations));
	}
}
