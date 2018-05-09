//Leetcode problem 698 Partition to K Equal Sum Subsets
//Solution written by Xuqiang Fang on 5 May, 2018
import java.util.ArrayList;
import java.util.List;
class Solution{
    //Solution provided by user@caihao0727mail
    public boolean canPartitionKSubsets(int[] nums , int k){
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(k <= 0 || sum % k != 0)
            return false;
            
        int[] visited = new int[nums.length];
        return dfs(nums, visited, 0, k, 0, 0, sum/k);
    }
        
    private boolean dfs(int[] nums, int[] visited, int index, int k, int sum, int num, int target){
        if(k == 1)
            return true;
        if(sum == target && num > 0)
            return dfs(nums, visited, 0, k-1, 0, 0, target);
        for(int i=index; i<nums.length; ++i){
            if(visited[i] == 0){
                visited[i] = 1;
                if(dfs(nums, visited, i+1, k, sum + nums[i], num+1, target))
                    return true;
                visited[i] = 0;
            }
        }
        return false;
    }
}

public class EqualPartitionSubsets{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {4,3,2,3,5,2,1,1,1,1,1,1,1,1,1};
        int[] nums2 = {2,2,2,2,3,4,5};//test 4
        int[] nums3 = {1,2,3,4,5,5,5,5,5,5,5,5,5,5,5,5};
        int[] nums4 = {3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269};// test 5
        
        //System.out.println(s.canPartitionKSubsets(nums, Integer.valueOf(args[0])));
        System.out.println(s.canPartitionKSubsets(nums4, Integer.valueOf(args[0])));
	}
}
