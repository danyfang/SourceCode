//Leetcode problem 507 Perfect Number
//Solution written by Xuqiang Fang on 27 April, 2018 

class Solution{
    public boolean checkPerfectNumber(int num){
        int sum = 1;
        for(int i=2; i<=(int)Math.sqrt(num); ++i){
            if(num % i == 0){
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }	
}

public class PerfectNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.checkPerfectNumber(Integer.valueOf(args[0])));
        for(int i=1; i<100000; ++i){
            if(s.checkPerfectNumber(i))
                System.out.println(i);
        }
	}
}
