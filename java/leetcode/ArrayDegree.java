//Leetcode problem  697 Degree of an Array
//Solution written by Xuqiang Fang on 4 May, 2018
class Solution{
    public int findShortestSubArray(int[] nums){
        int max = 0;
        int[][] index = new int[50000][3]; 
        for(int i=0; i<nums.length; ++i){
            max = Math.max(max, ++index[nums[i]][0]);
            if(index[nums[i]][0] == 1){
                index[nums[i]][1] = i;
            }
            index[nums[i]][2] = i;
        }
        int min = nums.length;
        for(int i=0; i<nums.length; ++i){
            if(index[nums[i]][0] == max){
                min = Math.min(min, index[nums[i]][2] - index[nums[i]][1]);
            }
        }

        return min;
    }
}

public class ArrayDegree{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
