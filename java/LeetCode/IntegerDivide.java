//Leetcode problem 29 Divide two integers
//solution written by Xuqiang Fang on 22 Feb. 2018
// divide two integers without using multiplication, division and mod operator
// currently not passed because of time limit exceeded
import java.lang.Math;
import java.lang.Integer;
class Solution{
	public int divide_(int dividend, int divisor){
		if(divisor == 0){
			return Integer.MAX_VALUE;
		}
		int result = 0;
		boolean symbol = false;
		if(dividend >=0 && divisor >= 0 || dividend < 0 && divisor < 0){
			symbol = true;
		}
		if(dividend == Integer.MIN_VALUE && divisor == -1){
			return	Integer.MAX_VALUE; 
		}
		dividend = Math.abs(dividend);
		divisor = Math.abs(divisor);
		while(dividend>= divisor){
			dividend = dividend - divisor;
			result++;
		}
		if(!symbol){
			return -result;
		}
		return result;
	}
    //Solution provided by user@daoheng
    public int divide(int dividend, int divisor){
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        int res = 0;
        int sign = (dividend < 0)^(divisor < 0) ? -1 : 1;
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);

        while(dvs <= dvd){
            long temp = dvs, mul = 1;
            while(dvd >= temp << 1){
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            res += mul;
        }
        return sign==1?res:-res;
    }
}
public class IntegerDivide{
	public static void main(String[] args){
		Solution s = new Solution();
		int a = -2147483648;
		int b = -1;
		System.out.println(s.divide(a,b));
		System.out.println(s.divide(4,3));
	}
}
