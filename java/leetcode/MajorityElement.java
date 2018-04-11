//Leetcode problem 169 Majority Element
//Solution written by Xuqiang Fang on 11 April, 2018 

class Solution{
    int majorityElement(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int majority = nums[0];
        int count = 0;
        for(int i : nums){
            if(i == majority)
                ++count;
            else if(--count == 0){
                count = 1;
                majority = i;
            }
        }

        return majority;
    }	
}

public class MajorityElement{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {54,2,1,4,4,4,4};
        System.out.println(s.majorityElement(nums));
	}
}
