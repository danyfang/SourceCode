//Leetcode problem 565 Array Nesting
//Solution written by Xuqiang Fang on 4 May, 2018
class Solution{
    public int arrayNesting(int[] nums){
        int max = 0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i]>=0 && nums[i]<nums.length){
                max = Math.max(max, search(nums, i));
            }
        } 
        return max;
    }
    private int search(int[] nums, int i){
        if(nums[i]>=0 && nums[i]<nums.length){
            System.out.println("i = " + i);
            int next = nums[i];
            nums[i] = -1;
            return 1 + search(nums, next);
        }
        return 0;
    }
}

public class ArrayNesting{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {5,4,0,3,1,6,2};
        System.out.println(s.arrayNesting(nums));
	}
}
