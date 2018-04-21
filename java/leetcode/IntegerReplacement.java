//Leetcode problem 397 Integer Replacement
//Solution written by Xuqiang Fang on 21 April, 2018 

//solution provided by user@SergeyTachenov
/*
If n is even, halve it.
If n=3 or n-1 has less 1’s than n+1, decrement n.
Otherwise, increment n.

*/
class Solution{
    public int integerReplacement(int n){
        int c = 0;
        while(n != 1){
            if((n & 1) == 0){
                n >>>= 1;
            }else if(n == 3 || ((n >>> 1) & 1) == 0){
                --n;
            }else{
                ++n;
            }
            ++c;
        }
        return c;
    }	

    public int log2(int n){
        return (int)(Math.log(n)/Math.log(2));
    }
}

public class IntegerReplacement{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.integerReplacement(Integer.valueOf(args[0])));
        System.out.println(s.log2(Integer.valueOf(args[0])));
	}
}
