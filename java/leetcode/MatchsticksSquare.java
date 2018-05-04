//Leetcode problem  473 Matchsticks to Square
//Solution written by Xuqiang Fang on 4 May, 2018
class Solution{
    public boolean makesquare(int[] nums){
        if(nums == null || nums.length < 4)
            return false;
        int sum = 0;
        int max = 0;
        for(int i : nums){
            sum += i;
            max = Math.max(max, i);
        }
        if(sum % 4 != 0 || max > sum / 4){
            return false;
        }
        int length = sum / 4;
        System.out.println(length);
        bfs(nums, length, length, 0);
        for(int i : nums){
            if(i >= 0)
                return false;
        }
        return true;
    }
    private void bfs(int[] nums, int length, int gap, int level){
        if(gap == 0){
            for(int i : nums){
                if(i >= 0){
                    bfs(nums, length, length, 0);
                }
            }
            return;
        }
        for(int i=level; i<nums.length; ++i){
            if(nums[i] >= 0 && gap >= nums[i]){
                int tmp = nums[i];
                nums[i] = -1;
                bfs(nums, length, gap - tmp, i+1);
                for(int j : nums){
                    if(j >= 0)
                        nums[i] = tmp;
                }
            }
        }
        //System.out.println("how many times ehre");
    }
}

public class MatchsticksSquare{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,1,2,2,2};
        int[] nums2 = {3,3,3,3,4};
        int[] nums3 = {5,5,5,5,4,4,4,4,3,3,3,3};
        System.out.println(s.makesquare(nums2));
        System.out.println(s.makesquare(nums3));
        for(int i : nums3){
            System.out.println(i);
        }
	}
}
