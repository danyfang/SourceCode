//Leetcode problem 91 Decode Ways
//Solution written by Xuqiang Fang on 24 March 2018 
//Solution takes reference from user@yfcheng
class Solution{
	public int numDecodings(String s){
		if(s == null || s.length() == 0 || s.charAt(0) == '0'){
			return 0;
		}
		int[] nums = new int[s.length()+1];
		nums[0] = 1;
		nums[1] = s.charAt(0) != '0' ? 1 : 0;
		int first = 0;
		int second = 0;
		for(int i=1; i<s.length(); i++){
			first = Integer.valueOf(s.substring(i,i+1));
			second = Integer.valueOf(s.substring(i-1,i+1));
			
			if(first >= 1 && first <= 9){
				nums[i+1] = nums[i];
			}
			if(second >= 10 && second <= 26){
				nums[i+1] += nums[i-1];
			}
		}
		return nums[s.length()];
	}	
}
public class DecodeWays{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.numDecodings(args[0]));
	}
}
