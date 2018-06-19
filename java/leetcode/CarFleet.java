//Leetcode problem 853 Car Fleet
//Solution written by Xuqiang Fang on 18 June, 2018
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
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        if(n == 0){
            return 0;
        }
        int[][] car = new int[n][2];
        for(int i=0; i<n; ++i){
            car[i][0] = target - position[i];
            car[i][1] = speed[i];
        }
        Arrays.sort(car, (a,b)->(a[0]-b[0]));
        int ans = 1;
        double prev = (double)car[0][0] / (double)car[0][1];
        for(int i=1; i<n; ++i){
            double t = (double)car[i][0] / (double)car[i][1];
            if(t > prev){
                ans++;
                prev = t;
            }
        }
        return ans;
    }
}

public class CarFleet{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] p = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(s.carFleet(12, p, speed));
	}
}
