//Leetcode problem 456 132 Pattern
//Solution written by Xuqiang Fang on 2 May, 2018
import java.util.Stack;
class Solution{
    //O(n^2) solution
    public boolean find132(int[] nums){
        if(nums == null || nums.length < 3)
            return false;
        int n = nums.length;
        for(int i=0; i<n-2; ++i){
            int max = nums[i];
            for(int j=i+1; j<n; ++j){
                if(nums[j] > max){
                    max = nums[j];
                } 
                else if(nums[j]<max && nums[j]>nums[i]){
                    return true;
                }
            }
        }
        return false;
    }	
    //single pass O(n)
    /*
    Start from the right, keep track of the largest s3 value of all (s2, s3) pairs
    that is , s2 and s3 should be as close as possible, therefore any number that 
    is smaller than s3 would mean the result is true
    */
    public boolean find132pattern(int[] nums){
        if(nums == null || nums.length < 3){
            return false;
        } 
        int s3 = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();//use stack to store all candiates for s2
        int n = nums.length;
        for(int i=n-1; i>=0; --i){
            if(nums[i] < s3)
                return true;
            else{
                while(!stack.isEmpty() && nums[i] > stack.peek()){
                    s3 = stack.pop();
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}

public class OneThreeTwoPattern{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,3,4};
        int[] nums1 = {3,1,4,2};
        int[] nums2 = {-1,3,2,0};
        System.out.println(s.find132pattern(nums));
        System.out.println(s.find132pattern(nums1));
        System.out.println(s.find132pattern(nums2));
	}
}
