//Leetcode problem 84 Largest Rectangle in Histogram
//Solution written by Xuqiang Fang on 
import java.util.Stack;
class Solution{
	//straightforward but stupid solution
	public int largestRectangleArea_(int[] heights){
		if(heights == null)
			return 0;

		int area = 0;
		int temp = 0;
		for(int i=1; i<=heights.length; i++){
			for(int j=0; j<=heights.length-i; j++){
				temp = i * min(j,i,heights);
				area = temp > area ? temp : area;
			}
		}
		return area;	
	}	
	public int min(int index, int length, int[] heights){
		int m = heights[index];
		for(int j=index+1; j<index+length; j++){
			m = heights[j] > m ? m : heights[j];	
		}
		return m;
	}
	
	//stack Solution
	public int largestRectangleArea(int[] heights){
		int n = heights.length;
		Stack<Integer> stack = new Stack<>();
		int area = 0;
		for(int i=0; i<=n; i++){
			int h = i == n ? 0 : heights[i];
			while(!stack.isEmpty() && h < heights[stack.peek()]){
				int curHeight = heights[stack.pop()];
				int preIndex = stack.isEmpty() ? -1 : stack.peek();
				area = Math.max(area, curHeight * (i - preIndex -1));
			}
			stack.push(i);
		}
		return area;
	}
}

public class HistogramRectangle{
	public static void main(String[] args){
		Solution s = new Solution();
		int[] nums = {2,1,5,6,2,3};
		System.out.println(s.largestRectangleArea(nums));
	}
}
