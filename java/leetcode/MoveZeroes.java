//Leetcode problem 283 Move Zeroes
//Solution written by Xuqiang Fang on 14 April, 2018 

class Solution{
    public void moveZeroes(int[] nums){
        int start = 0;//denote index of zero
        int curr = start;//denote index of non-zero
        while(start <nums.length && curr< nums.length){
            if(nums[start] != 0){
                start++;
                continue;
            }
            curr = start + 1;
            while(curr < nums.length){
                if(nums[curr] != 0){
                    nums[start++] = nums[curr];
                    nums[curr] = 0;
                    break;
                }
                curr++;
            }
        }
    }	
}

public class MoveZeroes{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {0,1,0,3,12};
        s.moveZeroes(nums);
        print(nums);
	}
    public static void print(int[] nums){
        for(int i : nums)
            System.out.println(i);
    }
}
