//Leetcode problem 154 FindMinimum in Rotated Sorted Array II
//Solution written by Xuqiang Fang on 22 March 2018 
//{10,1,10,10,10,10,10,10,10}
//{3,3,1,3}
//when nums[mid] == nums[tail], we are not sure if the minimum is at left or right, both are possible.
class Solution{
	public int findMin(int[] nums){
		int head = 0;
		int tail = nums.length-1;
		int min = nums[0];
		while(head <= tail){
			if(nums[head] < nums[tail]){
				min = nums[head];
				return min;
			}
			if(head == tail || head == tail-1){
				min = nums[head] > nums[tail] ? nums[tail] : nums[head];
				return min;
			}
			int mid = head + (tail - head)/2;
			if(nums[mid] <= nums[tail]){
				if(nums[mid] == nums[tail]){
					head++;
					tail--;
				}else{
					tail = mid;
				}
			}else{
				head = mid;
			}
		}
		return min;
	}	
}

public class MiniSortedArrayDuplicate{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {10,1,10,10,10,10,10,10,10};
		int[] nums2 = {3,3,1,3};
		System.out.println(s.findMin(nums));
		System.out.println(s.findMin(nums2));
	}
}
