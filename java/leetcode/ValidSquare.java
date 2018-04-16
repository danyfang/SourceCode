//Leetcode problem 367 Valid Perfect Square
//Solution written by Xuqiang Fang on  16 April, 2018

class Solution{
    public boolean isPerfectSquare(int num) {
        if(num == 1)
            return true;
        int l = 1;
        int r = num / 2;
        int m = l + (r - l) / 2;
        while(l < r){
            if((l == num / l && num % l == 0) || (r == num / r && num % r == 0))
                return true;
            m = l + (r - l) / 2;
            if(m == num / m && num % m == 0)
                return true;
            else if(m < num / m + 1)
                l = m + 1;
            else
                r = m - 1;
        }
        return false;
    }	
}

public class ValidSquare{
	public static void main(String[] args){
		Solution s = new Solution();
        for(int i=1; i<=10000; i++){
            if(s.isPerfectSquare(i))
                System.out.println(i);
        }
        System.out.println(s.isPerfectSquare(Integer.valueOf(args[0])));
	}
}
