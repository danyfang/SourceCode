//Leetcode problem 217 Contains Duplicate
//Leetcode problem 219 Contains Duplicate II
//Leetcode problem 220 Contains Duplicate III
//Solution written by Xuqiang Fang on 22 March 2018
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
class Solution{
	public boolean containsDuplicate(int[] nums) {
    	Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i],1);
			}else{
				return true;
			}
		}
		return false;
    }	
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			if(!map.containsKey(nums[i])){
				map.put(nums[i], i);
			}else{
				if(i - map.get(nums[i]) <= k){
					System.out.println(nums[i] + "key" + i+ map.get(nums[i]));
					return true;
				}else{
					map.replace(nums[i],i);
				}
			}
		}
		return false;
	}
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t < 0) return false;
        Map<Long, Long> dict = new HashMap<>();
        long w = (long)t + 1;
        for(int i=0; i<nums.length; ++i){
            long m = getID(nums[i], w);
            if (dict.containsKey(m)) return true;
            else if(dict.containsKey(m-1) && Math.abs(nums[i]-dict.get(m-1))<w) return true;
            else if(dict.containsKey(m+1) && Math.abs(nums[i]-dict.get(m+1))<w) return true;

            dict.put(m, (long)nums[i]);
            if(i >= k) dict.remove(getID(nums[i-k], w));
        }
        return false;
	}
    private long getID(long i, long w){
        return i < 0 ? (i+1) / w -1 : i / w;
    }
}

public class ContainDuplicate{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,6,2,34,5,6};
		int[] nums2 = {1,2,3,4,1,3,2,1};
		System.out.println(s.containsDuplicate(nums));
		System.out.println(s.containsNearbyAlmostDuplicate(nums2,2,3));
	}
}
