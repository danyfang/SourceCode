//Leetcode problem 414 Third Maximum Number
//Solution written by Xuqiang Fang on 22 April, 2018 

class Solution{
    public int thirdMax(int[] nums){
        int first = nums[0];
        int second = nums[0];
        int third = nums[0];
        for(int i : nums){
            first = Math.max(i, first);
            second = Math.min(i, second);
        }
        third = second;
        for(int i : nums){
            if(i > first){
                third = second;
                second = first;
                first = i;
            }
            if(i > second && i < first){
                third = second;
                second = i;
            }
            if (i > third && i < second){
                third = i;
            }
        }

        if(third == second || second == first)
            return first;
        return third;
    }	
}

public class ThirdMaximum{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {2,1,0};
        System.out.println(s.thirdMax(nums));
	}
}
