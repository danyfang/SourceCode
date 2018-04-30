//Leetcode problem 611 Valid Triangle Number
//Solution written by Xuqiang Fang on 30 April, 2018 
import java.util.Arrays;
class Solution{
    public int triangleNumber(int[] nums){
        Arrays.sort(nums);
        int count = 0; 
        int n = nums.length;
        for(int i=n-1; i>=2; --i){
            int right = i-1;
            int left = 0;
            while(left < right){
                if(nums[left] + nums[right] > nums[i]){
                    count += right - left;
                    --right;
                }
                else{
                    ++left;
                }
            }
        }
        return count;
    }	
}

public class ValidTriangle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {2,2,3,4};
        System.out.println(s.triangleNumber(nums));
	}
}
