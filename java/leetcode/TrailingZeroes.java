//Leetcode problem 172 Factorial Trailing  Zeroes
//Solution written by Xuqiang Fang on 12 April, 2018 

class Solution{
    public int trailingZeroes(int n){
        int exp = 0;
        int temp = n;
        while(temp >= 5){
            exp++;
            temp = temp / 5;
        }
        int count = 0;
        for(int i = 1; i<=exp; i++){
            count += n / ((int)Math.pow(5,i));
        }
        return count;
    }	
}

public class TrailingZeroes{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.trailingZeroes(Integer.valueOf(args[0])));
	}
}
