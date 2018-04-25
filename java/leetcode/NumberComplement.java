//Leetcode problem 476 Number Complement
//Solution written by Xuqiang Fang on 24 April, 2018 

class Solution{
    public int findComplement(int num){
        int n = Integer.toBinaryString(num).length();
        long m = num;
        long result = (long)Math.pow(2,n)-1 - m;
        return (int)result;
    }	
}

public class NumberComplement{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findComplement(Integer.valueOf(args[0])));
	}
}
