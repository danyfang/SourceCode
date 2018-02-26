//Leetcode problem 11 Container with most water
//Solution written by Xuqiang Fang on 25 Feb, 2018
//the first solution was exceeding the time limit
//the second solution was accepted! Inlight by the analysis written by user@@vinod23
class Solution{
	public int maxAreaTimeExceed(int[] height){
		int n = height.length;
		int foot = 0;
		int max = 0;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				int temp =  min(height[i], height[j])*(j-i);
				max = temp > max? temp:max ;	
			}
		}
		
		return max;
	}
	public int min(int a, int b){
		return a > b ? b:a;
	}
	public int maxArea(int[] height){
		int left = 0;
		int right = height.length-1;
		int max = 0;
		while(left<right){
			if(height[left] <= height[right]){
				max = max > height[left] * (right-left) ? max : height[left]*(right-left);
				left++;
			}else{
				max = max > height[right] * (right-left) ? max : height[right]*(right-left);
				right--;
			}
		}
		return max;
	}
}

public class WaterContainer{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {1,2,3,4,5};
		System.out.println(s.maxArea(nums));
		return;
	}
}
