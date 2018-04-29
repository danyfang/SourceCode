//Leetcode problem 594 Longest Harmonious Subsequence
//Solution written by Xuqiang Fang on 29 April, 2018 
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int findLHS(int[] nums){
        Map<Integer, Integer> map = new HashMap<>(); 
        int length = 0;
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        for(int i : map.keySet()){
            if(map.containsKey(i-1)){
                length = Math.max(length, map.get(i-1)+map.get(i));
            }
            if(map.containsKey(i+1)){
                length = Math.max(length, map.get(i+1)+map.get(i));
            }
        }
        return length;
    }	
}

public class HarmoniousSubsequence{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(s.findLHS(nums));
	}
}
