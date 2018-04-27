//Leetcode problem 540 Single Element in a Sorted Array
//Solution written by Xuqiang Fang on 27 April, 2018 

class Solution{
    public int singleNonDuplicate(int[] nums){
        if(nums == null || nums.length == 0)
            return -1;
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int m = 0;
        while(l < r){
            if(nums[r] != nums[r-1])
                return nums[r];
            else if(nums[l] != nums[l+1])
                return nums[l];
            m = l + (r - l) / 2;
            System.out.println("m = " + m + " nums[m] = " + nums[m]);
            if(nums[m] == nums[m-1]){
                if((m-l+1)%2 == 0){
                    l = m + 1;
                }
                else{
                    r = m;
                }
            }
            else if(nums[m] == nums[m+1]){
                if((r-m+1) % 2 == 0){
                    r = m - 1;
                }
                else{
                    l = m;
                }
            }
            else{
                return nums[m];
            }
        }
        return nums[m];
    }	
}

public class SingleElement{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,1,2,2,3,3,4,5,5,6,6,7,7,8,8,9,9,11,11,12,12};
        System.out.println("r = " + (nums.length-1));
        System.out.println(s.singleNonDuplicate(nums));
	}
}
