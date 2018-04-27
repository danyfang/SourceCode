//Leetcode problem 452 Minimum Number of Arrows to Burst Balloons
//Solution written by Xuqiang Fang on 26 April, 2018 
/*
greedy algorithm
The idea is to merge connected intervals, and we start processing from either ends
the reason is that the end interval must cost one arrow
suppose we start from left, the first interval has to cost one arrow, so if we merge all
intervals that are connected to the first interval, then the cost of arrows is minimized
(at least this wont cost the number of arrows to be bigger than needed)


So we need to sort all intervals based on their ending point
*/
import java.util.Arrays;

class Solution{
    public int findMinArrowShots(int[][] points){
        if(points == null || points.length == 0)
            return 0;

        Arrays.sort(points, (a,b)->a[1] - b[1]);

        int index = points[0][1];
        int count = 1;
        for(int i=1; i<points.length; ++i){
            if(points[i][0] <= index){
                continue;
            }
            count++;
            index = points[i][1];
        }

        return count;
    }
}

public class BurstBalloons{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        System.out.println(s.findMinArrowShots(points));
	}
}
