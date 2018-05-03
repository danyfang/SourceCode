//Leetcode problem 633 Sum of Square Numbers
//Solution written by Xuqiang Fang on 3 May,2018

class Solution{
    public boolean judgeSquareSum(int c){
        int m = (int)Math.sqrt(c); 
        if(m * m == c)
            return true;
        for(int i=1; i<=m; ++i){
            int n = (int)Math.sqrt(c-i*i);
            if(n*n == c - i*i)
                return true;
        }
        return false;
    }	
}

public class SquareNumbersSum{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.judgeSquareSum(Integer.valueOf(args[0])));
	}
}
