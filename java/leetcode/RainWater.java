//Leetcode problem 42 Trapping Rain Water
//Solution written by Xuqiang Fang on 24 March 2018 
//Solution accepted
class Solution{
	public int trap(int[] height){
		if(height == null || height.length <= 2)
			return 0;

		int H = 0;
		int I = 0;
		for(int i=0; i<height.length; i++){
			I = height[i] > H ? i : I;
			H = height[i] > H ? height[i] : H;
		}
		
		int sum = 0;
		int trap = 0;

		int preHeight = 0;
		for(int i=0; i<I; i++){
			trap += height[i];
			preHeight = height[i] > preHeight ? height[i] : preHeight;
			sum += preHeight ;
		}
		sum = sum - trap;
		//System.out.println("sum = " + sum);
		//System.out.println("trap = " + trap);
		
		trap = 0;
		preHeight = 0;
		for(int i=height.length-1; i>I; i--){
			trap += height[i];
			preHeight = height[i] > preHeight ? height[i] : preHeight;
			sum += preHeight;

		}
		//System.out.println("trap = " + trap);
		sum  = sum - trap;
		return sum;
	}	
}

public class RainWater{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {4,1,0,2,1,0,1,1,2,1,2};
		System.out.println(s.trap(nums));
	}
}
