//Leetcode problem 89 Gray Code
//Solution written by Xuqiang Fang on  24 March 2018
//Solution accepted
import java.util.List;
import java.util.ArrayList;

class Solution{
	public List<Integer> grayCode(int n){
		List<Integer> list = new ArrayList<>();	
		int[] nums = new int[(int)Math.pow(2,n)];
		list.add(0);
		if(n == 0)
			return list;
		nums[0] = 0;
		nums[1] = 1;
		list.add(1);
		int index = 0;
		for(int i=1; i<n; i++){
			index = (int)Math.pow(2,i);	
			for(int j=0; j<index; j++){
				nums[index+j] = index + nums[index-1-j];
				list.add(nums[index+j]);
			}	
		}
		index = (int)Math.pow(2,n);
		return list;
	}
}

public class GrayCode{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.grayCode(Integer.valueOf(args[0])));
	}
}
