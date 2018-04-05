//Leetcode problem 7 Reverse Integer
//Solution written by Xuqiang Fang on 25 March 2018 

class Solution{
	public int reverse(int x){
		int result = 0;
		int prev = 0;
		while(x != 0){
			result *= 10;
			result += x % 10;
			if(result / 10 != prev){
				return 0;
			}
			x = x / 10;
			prev = result;	
		}		
		return result;
	}		
}

public class ReverseInteger{
	public static void main(String[] args){
		Solution s = new Solution();
		System.out.println(s.reverse(Integer.valueOf(args[0])));
	}
}
