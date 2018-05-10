//Leetcode problem 532 k-diff Pairs in an Array
//Solution written by Xuqiang Fang on 9 May, 2018
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int findPairs(int[] nums, int k){
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        if(k == 0){
            for(int i : nums){
                map.put(i, map.getOrDefault(i, 0) + 1);
                if(map.get(i) == 2)
                    res++;
            }
        }
        else if(k > 0){
            for(int i : nums){
                map.put(i, map.getOrDefault(i, 0) + 1);
                if(map.get(i) == 1){
                    if(map.containsKey(i-k))
                        res++;
                    if(map.containsKey(i+k))
                        res++;
                }
            }
        }
        return res;
    }
}

public class KDiffPairs{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,1,4,1,5};
        int[] nums2 = {1,2,3,4,5};
        int[] nums3 = {1,3,1,5,4};
        System.out.println(s.findPairs(nums, 2));
        System.out.println(s.findPairs(nums2, 1));
        System.out.println(s.findPairs(nums3, 0));
	}
}
