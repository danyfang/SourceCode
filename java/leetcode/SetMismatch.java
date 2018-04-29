//Leetcode problem 645 Set Mismatch
//Solution written by Xuqiang Fang on 29 April, 2018

class Solution{
    public int[] findErrorNums(int[] nums){
        int N = nums.length;
        int[] ret = new int[2];
        int[] unit = new int[N];
        int another = 0;
        int sum = 0;
        for(int i=0; i<N; ++i){
            sum += nums[i];
            if(unit[nums[i]-1] == 0){
                unit[nums[i]-1] = nums[i];
            }
            else{
                another = nums[i]; 
            }
        }
        int missing = N*(N+1)/2 - sum + another;
        ret[0] = another;
        ret[1] = missing;
        return ret;
    }	
}

public class SetMismatch{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,2,2,3,4,5,6,7,8};
        int[] ret = s.findErrorNums(nums);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
	}
}
