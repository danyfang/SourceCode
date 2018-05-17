//Leetcode problem 398 Random Pick Index
//Solution written by Xuqiang Fang on 16 May, 2018
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
class Solution {
    public Solution(int[] nums) {
        map = new HashMap<>();
        r = new Random();
        for(int i=0; i<nums.length; ++i){
            if(!map.containsKey(nums[i])){
                List<Integer> list = new ArrayList<>();
                map.put(nums[i], list);
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> list = map.get(target);
        return list.get(r.nextInt(list.size()));
    }
    private Map<Integer, List<Integer>> map;
    private Random r;
}

public class RandomIndex{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
