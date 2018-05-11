//Leetcode problem 33 Search in Rotated Sorted Array
//Leetcode problem 81 Search in Rotated Sorted Array II
//Solution written by Xuqiang Fang on 22 March 2018 
//Solution provided by user@da.lin.1232
class Solution{
	//no duplicates
	public int search_(int[] nums, int target) {
    	int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			
			int num = nums[mid];
			// If nums[mid] and target are "on the same side" of nums[0], we just take nums[mid].
			if ((nums[mid] < nums[0]) == (target < nums[0])) {
				num = nums[mid];
			} else {
				num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
			}

			if (num < target)
				lo = mid + 1;
			else if (num > target)
				hi = mid - 1;
			else
				return mid;
		}
   		return -1;
	}
	//duplicates are allowed
	public boolean search(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return false;
        int lo = 0;
        int hi = nums.length-1;
        while(lo < hi){
            int m = lo + (hi - lo) / 2;
            if(nums[m] == target){
                return true;
            }
            if(nums[lo] < nums[m]){
                if(nums[lo] <= target && target < nums[m]){
                    hi = m - 1; 
                }
                else{
                    lo = m + 1;
                }
            }
            else if(nums[m] < nums[hi]){
                if(nums[m] < target && target <= nums[hi]){
                    lo = m + 1;
                } 
                else{
                    hi = m - 1;
                }
            }
            else{
                if(nums[m] == nums[lo])
                    ++lo;
                if(nums[m] == nums[hi])
                    --hi;
            }
        }

        return nums[lo] == target ? true : false;
	}
}

public class RotatedArray{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {5,1,3};
		System.out.println(s.search(nums, Integer.valueOf(args[0])));
	}
}
