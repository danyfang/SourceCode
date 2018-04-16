//Leetcode problem 343 Integer Break
//Solution written by Xuqiang Fang on 15 April, 2018 
/*
1*3 < 4
2* 3 > 5
2^3 < 3 ^ 2 > 4 *2 > 5 * 1
If an optimal product contains a factor f >= 4, then you can replace it with factors 2 and f-2 without losing optimality, as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4, meaning you only need factors 1, 2 and 3 (and 1 is of course wasteful and you’d only use it for n=2 and n=3, where it’s needed).
*/
class Solution{
    public int integerBreak(int n){
        if(n <= 3)
            return n-1;
        int m = n / 3;
        if(n % 3 == 1)
            return (int)Math.pow(3,m-1)*4;
        if(n % 3 == 2)
            return (int)Math.pow(3,m)*2; 
        return (int)Math.pow(3,m);
    }	
}

public class IntegerBreak{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.integerBreak(Integer.valueOf(args[0])));
	}
}
