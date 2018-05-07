//Leetcode problem 485 Max Consecutive Ones
//Solution written by Xuqiang Fang on 6 May, 2018
class Solution{
    public int findMaxConsecutiveOnes(int[] nums){
        int prev = 0;
        int count = 0;
        int max = 0;
        for(int i=0; i<nums.length; ++i){
            if(prev == 1 && nums[i] == prev){
                count++;
                max = Math.max(count, max);
                prev = nums[i];
            }
            else if(prev != nums[i]){
                if(prev == 0){
                    count = 1;
                    max = Math.max(count, max);
                    prev = 1;
                } 
                else{
                    count = 0;
                    prev = 0;
                }
            }
        }

        return max;
    }

    public int findMax(int[] nums){
        StringBuilder sb = new StringBuilder();
        for(int i : nums)
            sb.append(i);
        String[] s = sb.toString().split("0");
        int max = 0;
        for(String st : s){
            max = Math.max(st.length(), max);
        }
        return max;
    }
}

public class MaxConsecutiveOnes{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(s.findMaxConsecutiveOnes(nums));
	}
}
