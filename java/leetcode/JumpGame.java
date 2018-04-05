//Leetcode problem 55 Jump Game
//Leetcode problem 45 Jump Game II
//Solution written by Xuqiang Fang on 24 March 2018 

class Solution{
	//Solution exceeded time limit
	public boolean canJump_(int[] nums){
		if(nums == null || nums.length <= 0)
			return false;

		boolean[] flag = new boolean[nums.length];
		flag[0] = true;
		for(int i=0; i<nums.length; i++){
			int j = nums[i];
			if(flag[i]){
				while(j > 0 ){
					if(i+j < nums.length)
						flag[i+j] = true;
					j--;
				}
			}
		}
		return flag[nums.length-1];
	}	
	public boolean canJump(int[] nums){
		int reachable = 0;
		for(int i=0; i<nums.length; i++){
			if(i > reachable)
				return false;
			reachable = Math.max(reachable, i+nums[i]);
		}
		return true;
	}
	//solution accepted
	public int jump(int[] nums){
		if(nums == null || nums.length <= 1 || nums[0] == 0)
			return 0;
		int[] flag = new int[nums.length];
		int step = 1;
		int max = nums[0];
		int oldmax = nums[0];
		for(int i=1; i<nums.length; i++){
			if(i > oldmax){
				step++;
				oldmax = max;
			}
			

			if(max < nums.length)
				flag[max] = step;
			else{
				flag[nums.length-1] = step;
			}

			max = (i+nums[i]) > max ? (i+nums[i]) : max;
		}	
		return step;
	}
}

public class JumpGame{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {2,3,1,1,4};
		int[] nums2 = {3,2,1,0,4};
		int[] nums3 = {1,2,3,4,5};
		System.out.println(s.canJump(nums));
		System.out.println(s.canJump(nums2));
		System.out.println(s.jump(nums3));
	}
}
