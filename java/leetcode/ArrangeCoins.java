//Leetcode problem 441 Arranging Coins
//Solution written by Xuqiang Fang on 25 April, 2018 

class Solution{
    public int arrangeCoins(int n){
        long m = (long)n * 8 + 1;
        return ((int)Math.sqrt(m)-1)/2;
    }	
}

public class ArrangeCoins{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
