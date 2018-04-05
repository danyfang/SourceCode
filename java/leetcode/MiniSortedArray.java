//Leetcode problem 153 Find Minimum in Rotated Sorted Array
//Solution written by Xuqiang Fang on 22 March 2018 
//Solution accepted
class Solution{
	public int findMin(int[] nums){
		int head = 0;
		int tail = nums.length-1;
		int min = nums[0];
		if(nums[head] < nums[tail]){
			return min;
		}else{
			while(head <= tail){
				if(head == tail || head == tail-1){
					min = nums[head] > nums[tail] ? nums[tail] : nums[head];
					return min;
				}
				int mid = head + (tail - head)/2;
				if(nums[mid] < nums[tail]){
					tail = mid;
				}else{
					head = mid;
				}
			}
		}
		return min;
	}	
}

public class MiniSortedArray{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
