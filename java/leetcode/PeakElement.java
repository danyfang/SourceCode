//Leetcode problem  162 Find Peak Element
//Solution written by Xuqiang Fang on 14 May, 2018
class Solution{
    public int findPeakElement(int[] nums){
        int l = 0;
        int r = nums.length-1;
        while(l < r){
            int m1 = (l + r) / 2;
            int m2 = m1 + 1;
            if(nums[m1] < nums[m2]){
                l = m2;
            }
            else{
                r = m1;
            }
        }
        return l;
    }
}

public class PeakElement{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(s.findPeakElement(nums));
	}
}
