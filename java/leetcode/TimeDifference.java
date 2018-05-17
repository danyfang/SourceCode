//Leetcode problem 539 Minimum Time Difference
//Solution written by Xuqiang Fang on 16 May, 2018
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution{
    public int findMinDifference(List<String> timePoints) {
        int[] time = new int[1440];  
        if (timePoints.size() > 1440){
            return 0;
        }
        for(String point : timePoints){
            String[] timePoint = point.split(":");
            int hour = Integer.parseInt(timePoint[0]);
            int minute = Integer.parseInt(timePoint[1]);
            int index = hour * 60 + minute;
            time[index]++;
            if(time[index]>1)
                return 0;
        }
        int min = 720;
        int prev = -720;
        int curr = 0;
        int first = 0;
        boolean once = true;
        while(curr < time.length){
            if(time[curr] > 0){
                if(once){
                    first = curr;
                    once = false;
                }
                min = Math.min(min, curr-prev);
                prev = curr;
            }
            curr++;
        }
        int diff = first-prev;
        if(diff < 0){
            diff += 1440;
        }
        min = Math.min(min, diff);
        return min;
    }
}

public class TimeDifference{
	public static void main(String[] args){
		Solution s = new Solution();
        List<String> timePoints = Arrays.asList("00:00","23:59");
        System.out.println(s.findMinDifference(timePoints));
	}
}
