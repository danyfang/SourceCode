//Leetcode problem 495 Teemo Attacking
//Solution written by Xuqiang Fang on 16 May, 2018
class Solution{
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0)
            return 0;
        int timeStamp = timeSeries[0];
        int total = 0;
        for(int i=1; i<timeSeries.length; ++i){
            int add = timeStamp + duration > timeSeries[i] ? timeSeries[i] - timeStamp : duration;
            total += add;
            timeStamp = timeSeries[i];
        }
        total += duration;
        return total;
    }
}

public class TeemoAttacking{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] series = {1,4};
        int[] series2 = {1,2};
        System.out.println(s.findPoisonedDuration(series, 2));
        System.out.println(s.findPoisonedDuration(series2, 2));
	}
}
