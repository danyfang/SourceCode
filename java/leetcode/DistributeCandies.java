//Leetcode problem 575 Distribute Candies
//Solution written by Xuqiang Fang on 30 April, 2018 
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int distributeCandies(int[] candies){
        Map<Integer, Integer> map = new HashMap<>();
        int n = candies.length;
        for(int i : candies){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        if(map.size() >= n/2){
            return n/2;
        }
        
        return map.size();
    }	
}

public class DistributeCandies{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
