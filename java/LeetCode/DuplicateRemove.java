//Leetcode problem 26 Remove duplicates from sorted array
//Solution written by Xuqiang Fang on 22 Feb 2018
//the solution only requires O(1) sapce.

class Solution {
    public int removeDuplicates(int[] nums) {
       	int length = 0;
		if(nums == null || nums.length == 0){
			return length;
		}
		if(nums.length >= 1){
			length ++;
		}
		//nums.length >= 2 
		int num = 0;//count the repeated element;
		for(int i=1; i<nums.length; i++){
			if(nums[i] != nums[i-1]){
				nums[i-num] = nums[i];
				length++;
			}else{
				num++;
			}
		}
		return length;

    }
}

public class DuplicateRemove{
	public static void main(String[] args){
		int[] test = {1,1,2,3,4,5,9,10};
		int[] test2 = {1};
		Solution s = new Solution();
		System.out.println(s.removeDuplicates(test));
		System.out.println(s.removeDuplicates(test2));
		for(int i=0;i<s.removeDuplicates(test); i++){
			System.out.println(test[i]);
		}
	}
}
