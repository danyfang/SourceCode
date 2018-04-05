//Leetcode problem 34 Search for a Range
//Solution written by Xuqiang Fang on 12 March 2018 
/*
Given an array of integers sorted in ascending order, find the starting and
ending position of a given target value.
Your algorithm's runtime complexity must be in the order of O(log n).
*/

class Solution{
	public int[] searchRange(int[] nums, int target){
		int[] result = {-1,-1};
		if(nums == null || nums.length == 0){
			return result;
		}
		int head = 0;
		int tail = nums.length - 1;
		while(head <= tail){
			int mid = head + (tail - head)/2;
			if(nums[mid] == target){
				result[0] = findMin(nums, mid, target);
				result[1] = findMax(nums, mid, target);
				return result;
			}else if(nums[mid] > target){
				tail = mid;
			}else{
				head = mid;
			}
		}
		return result;
	}

	private int findMin(int[] nums, int index, int target){
		int min = index;
		for(int i=index; i>=0; i--){
			if(nums[i] == target)
				min = i;
		}
		return min;
	}
	private int findMax(int[] nums, int index, int target){
		int max = index;
		for(int i=index; i<nums.length; i++){
			if(nums[i] == target)
				max = i;
		}
		return max;
	}

	private void binarySearch(int[] nums, int left, int right, int target, int[] result){
		if(left < right)
			return;

		if(nums[left] == nums[right] && nums[left] == target){
			result[0] = left;
			result[1] = right;
			return;
		}

		int mid = left + (right-left)/2;
		if(nums[mid] < target){
			binarySearch(nums, mid+1, right, target, result);
		}else if(nums[mid] > target){
			binarySearch(nums,left, mid-1, target, result);
		}else{
			result[0] = mid;
			result[1] = mid;
			int t1 = mid;
			while(t1 > left && nums[t1] == nums[t1-1]){
				t1--;
				result[0] = t1;
			}
			int t2= mid;
			while(t2 < right && nums[t2] == nums[t2+1]){
				t2++;
				result[1] = t2;
			}
			return;
		}
	}
}

public class RangeSearch{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {8,8,8,8,8,10};
		int[] result = s.searchRange(nums, 8);

		for (int i=0; i<result.length; i++){
			System.out.println(result[i]);
		}
	}
}
