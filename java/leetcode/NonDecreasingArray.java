//Leetcode problem 665 Non-decreasing Array
//Solution written by Xuqiang Fang on 2 May, 2018

class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums == null || nums.length <= 1) return true;
        boolean found = false;
        for (int i = 1; i< nums.length; i++){
            if(nums[i]<nums[i-1]){
                if(found) return false;
                else {
                    if(i-2>=0 && nums[i]<nums[i-2]) nums[i] = nums[i-1];
                    found = true;
                }
            }
        }
        return true;
    }
}
public class NonDecreasingArray{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
