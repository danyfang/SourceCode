//Leetcode problem 747 Largest Number At Least Twice of Others
//Solution written by Xuqiang Fang on 3 May, 2018

class Solution{
    public int dominantIndex(int[] nums){
        int index = -1;
        int max = 0;
        for(int i=0; i<nums.length; ++i){
            if(nums[i] > max){
                max = nums[i];
                index = i;
            }
        }
        for(int i=0; i<nums.length; ++i){
            if(i != index){
                if(nums[i] * 2 > max)
                    return -1;
            }
        }
        return index;
    }	
}

public class LargestTwice{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {3,6,1,0};
        System.out.println(s.dominantIndex(nums));
	}
}
