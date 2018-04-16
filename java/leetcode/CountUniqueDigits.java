//Leetcode problem 357 Count Numbers with Unique Digits
//Solution written by Xuqiang Fang on 15 April, 2018 
//It's a permutation problem, to compute factorial
class Solution{
    public int countNumbersWithUniqueDigits(int n){
        int[] factorial = new int[10];
        factorial[0] = 10;
        factorial[1] = 91;
        for(int i=2; i<10; i++){
            factorial[i] = (factorial[i-1] - factorial[i-2]) * (10 - i ) + factorial[i-1];
        }
        return n >= 10 ? factorial[9] : factorial[n-1]; 
    }	
}

public class CountUniqueDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.countNumbersWithUniqueDigits(Integer.valueOf(args[0])));
	}
}
