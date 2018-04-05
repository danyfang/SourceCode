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
		for(int i=0; i<nums.length-k; i++){
			for(int j=1; j<=k; j++){
				if(Math.abs(nums[i]-nums[i+j])<=t){
					return true;
				}
			}
		}
		return false;
	}
}

public class ContainDuplicate{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,6,2,34,5,6};
		int[] nums2 = {1,2,3,4,1,3,2,1};
		System.out.println(s.containsDuplicate(nums));
		System.out.println(s.containsNearbyDuplicate(nums2,2));
	}
}
