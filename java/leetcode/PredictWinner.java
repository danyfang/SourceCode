//Leetcode problem 486 Predict the Winner
//Solution written by Xuqiang Fang on 17 May, 2018
class Solution{
    public boolean PredictTheWinner(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }
        int max = maxPoints(nums, 0, nums.length-1);
        System.out.println("max = " + max);
        return max >= sum-max;
    }
    //define maxPoints as max points play one can obtain from i and j (exclusive)
    private int maxPoints(int[] nums, int i, int j){
        if(j==i){
            return nums[i];
        }
        else if(j-i==1){
            return Math.max(nums[i], nums[i+1]);
        }
        else if(j-i==2){
            return Math.max(nums[i]+Math.min(nums[i+1],nums[i+2]),nums[j]+Math.min(nums[j-1], nums[j-2]));
        }
        int common = maxPoints(nums,i+1,j-1);
        int first = maxPoints(nums,i+2,j);
        int last = maxPoints(nums,i,j-2);
        int begin = nums[i];
        int end = nums[j];
        begin += Math.min(common, first);
        end += Math.min(last, common);
        return Math.max(begin, end);
    }
}

public class PredictWinner{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,5,2};
        int[] nums2 = {1,5,233,7};
        int[] nums3 = {0,0,7,6,5,6,1};
        System.out.println(s.PredictTheWinner(nums));
        System.out.println(s.PredictTheWinner(nums2));
        System.out.println(s.PredictTheWinner(nums3));
	}
}
