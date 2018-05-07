//Leetcode problem 698 Partition to K Equal Sum Subsets
//Solution written by Xuqiang Fang on 5 May, 2018
import java.util.Arrays;
class Solution{
    public boolean canPartitionKSubsets(int[] nums , int k){
        if(k == 1)
            return true;
        Arrays.sort(nums);
        int sum = 0; 
        int n = nums.length;
        for(int i : nums){
            sum += i;
        }
        System.out.println("sum = " + sum);
        if(sum % k != 0 || nums[n-1] > sum / k)
            return false;

        System.out.println("sum/k = " + sum/k);
        dfs(nums, sum/k, sum/k);
        for(int i=0; i<nums.length; ++i){
            System.out.println("nums[i] = " + nums[i]);
            if(nums[i] > 0)
                return false;
        }
        return true;
    }
        
    private void dfs(int[] nums, int length, int gap){
    }
}

public class EqualPartitionSubsets{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,3,2,3,5,2,1,1,1,1,1,1,1,1,1};
        int[] nums2 = {2,2,2,2,3,4,5};
        int[] nums3 = {1,2,3,4,5,5,5,5,5,5,5,5,5,5,5,5};
        //System.out.println(s.canPartitionKSubsets(nums, Integer.valueOf(args[0])));
        System.out.println(s.canPartitionKSubsets(nums2, Integer.valueOf(args[0])));
	}
}
