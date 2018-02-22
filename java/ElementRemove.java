//Leetcode problem 27 Remove Element
//solution written by Xuqiang Fang on 22 Feb, 2018
//the solution only requires O(1) space;


class Solution {
    public int removeElement(int[] nums, int val) {
       	if(nums == null){
			return 0;
		} 
		int offset = 0;
		int length = 0;
		for(int i=0; i<nums.length; i++){
			if(nums[i] == val){
				offset++;	
				continue;
			}
			if(nums[i] != val){
				nums[i-offset] = nums[i];
				length++;
			}
		}
		return length; 
    }
}

public class ElementRemove{
	public static void main(String[] args){
		int[] test = {3,2,2,3,4,3,5};
		Solution s = new Solution();
		int length = s.removeElement(test,3);
		System.out.println(length);
		for(int i=0; i<length;i++){
			System.out.println(test[i]);
		}
		return;
	}
}
