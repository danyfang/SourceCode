//Leetcode problem 829 Consecutive Numbers Sum
//Solution written by Xuqiang Fang on 7 May, 2018
class Solution{
    public int consecutiveNumbersSum(int N){
        int count = 1;
        for(int i=2; i<=(int)Math.sqrt(2*N); ++i){
            if(((N - i*(i-1)/2))%i == 0)
                count++;
        }
        return count;
    }
}

public class ConsecutiveNumbers{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.consecutiveNumbersSum(Integer.valueOf(args[0])));
	}
}
