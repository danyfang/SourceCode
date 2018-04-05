//Leetcode problem 80 Remove Duplicates from Sorted Array II
//Solution written by Xuqiang Fang on 22 March 2018 
class Solution{
	public int removeDuplicates(int[] nums){
		if(nums == null || nums.length < 1){
			return 0;
		}
		int count = 1;	
		int current = nums[0];
		int offset = 0;
		for(int i=1; i<nums.length; i++){
			nums[i - offset] = nums[i];
			if(nums[i] != current){
				current = nums[i];
				count = 1;
			}else{
				count++;
				if(count > 2){
					offset++;
				}
			}
		}
		return nums.length - offset;
	}	
	//another solution provided by user@issac3
	public int removeDuplicates(int[] nums) {
  		int i = 0;
   		for (int n : nums)
      	if (i < 2 || n > nums[i - 2])
        	nums[i++] = n;
   		return i;
	}
}

public class RemoveDuplicate{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,1,1,1,1,1,1,2,2,2,3,3,3,3,4,5,5,6,6};
		System.out.println(s.removeDuplicates(nums));
		print(nums);
	}
	public static void print(int[] nums){
		for(int i=0; i<nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
