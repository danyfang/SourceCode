//Leetcode problem 581 Shortest Unsorted Continuous Subarray
//Solution written by Xuqiang Fang on 3 May, 2018 
import java.util.Arrays;
class Solution{
    public int findUnsortedSubarray(int[] nums){
        int[] copy = new int[nums.length];
        for(int i=0; i<nums.length; ++i){
            copy[i] = nums[i];
        }
        Arrays.sort(copy);
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            if(nums[start] == copy[start]){
                start++;
            }
            if(nums[end] == copy[end]){
                end--;
            }
            if(nums[start] != copy[start] && nums[end] != copy[end]){
                break;
            }
        }
        if(start == end)
            return 0;
        return end-start+1;
    }	
}

public class UnsortedArray{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {2,6,4,8,10,9,15};
        System.out.println(s.findUnsortedSubarray(nums));
	}
}
