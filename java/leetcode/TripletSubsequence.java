//Leetcode problem 334 Increasing Triplet Subsequence
//Solution written by Xuqiang Fang on 23 April, 2018 

class Solution{
    public boolean increasingTriplet(int[] nums){
        if(nums == null || nums.length <= 2)
            return false;
        int n = nums.length;
        /*O(n^3) solution*/
        /*
        for(int i=0; i<n; ++i){
            for(int j=i+1; j<n; ++j){
                for(int k=j+1; k<n; ++k){
                    if(nums[i]<nums[j] && nums[j]<nums[k])
                        return true;
                }
            }
        }
        */

        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int i : nums){
            if(i <= first){
                first = i;
            }
            else if(i <= second){
                second = i;
            }
            else{
                return true;
            }
        }
        return false;
    }	
}

public class TripletSubsequence{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3,4,5};
        int[] nums1 = {0,4,2,1,0,-1,-3};
        System.out.println(s.increasingTriplet(nums));
        System.out.println(s.increasingTriplet(nums1));
	}
}
