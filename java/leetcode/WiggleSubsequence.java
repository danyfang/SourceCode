//Leetcode problem 376 Wiggle Subsequence
//Solution written by Xuqiang Fang on 18 April, 2018 

class Solution{
    public int wiggleMaxLength(int[] nums){
        if(nums == null || nums.length <= 0)
            return 0;
        if(nums.length == 1)
            return 1;
        if(nums.length == 2 && nums[0] == nums[1])
            return 1; 
        int n = nums.length;
        int[] diff = new int[n];
        diff[0] = 0;
        for(int i=1; i<n; i++){
            diff[i] = nums[i] - nums[i-1];
            //System.out.print(diff[i] + "\t");
        }
        int length = 2;
        int prev = 0;
        int next = 0;
        boolean same = true;
        for(int i=1; i<n; i++){
            if(diff[i] * diff[i-1] < 0){
                length++;
                same = false;
                continue;
            }
            if(diff[i] == 0 && diff[i-1] != 0){
                prev = diff[i-1];
                same = false;
            }
            if(diff[i] != 0 && diff[i-1] == 0){
                next = diff[i];
                if(prev * next < 0){
                    length++;
                    prev = 0;
                    next = 0;
                }
                same = false;
            }
        }
        if(same)
            length--;
        return length;
    }	
}

public class WiggleSubsequence{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,7,4,9,2,5};
        int[] nums2 = {1,17,5,10,13,15,10,5,16,8};
        int[] nums3 = {5,2,4,3,5,6,5,4,2,3,4,2,3,4,3,3,7,3,2,3,9,31,31,31,31,31};//21
        System.out.println(s.wiggleMaxLength(nums));
        System.out.println(s.wiggleMaxLength(nums2));
        System.out.println(s.wiggleMaxLength(nums3));
	}
}
