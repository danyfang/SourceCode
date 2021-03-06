//Leetcode problem 306 Additive Number
//Solution written by Xuqiang Fang on 18 April, 2018 
import java.math.BigInteger;
//solution provided by user@dietpepsi
class Solution{
    public boolean isAdditiveNumber(String num){
        if(num == null || num.length() < 3)
            return false;
        int n = num.length();
        for(int i=1; i<=n/2; ++i){
            if(num.charAt(0) == '0' && i > 1)
                return false;

            BigInteger x1 = new BigInteger(num.substring(0,i));
            for(int j=1; Math.max(j,i) <= n-i-j; ++j){
                if(num.charAt(i) == '0' && j > 1)
                    break;
                BigInteger x2 = new BigInteger(num.substring(i,i+j));
                if(isValid(x1,x2, j+i, num))
                    return true;
            }
        }
        return false;
    }	
    private boolean isValid(BigInteger x1, BigInteger x2, int start, String num){
        if(start == num.length())
            return true;
        x2 = x2.add(x1);
        x1 = x2.subtract(x1);
        String sum = x2.toString();
        return num.startsWith(sum, start) && isValid(x1,x2, start+sum.length(), num);
    }

    public boolean isAdditiveNumb(String num){
        if(num == null || num.length() < 3){
            return false;
        }
        int n = num.length();
        for(int i=1; i<=n/2; ++i){
            for(int j=1; j<=(n-i)/2; ++j){
                if(check(num.substring(0,i), num.substring(i,i+j), num.substring(i+j))){
                    return true;
                } 
            }
        }
        return false;
    }
    private boolean check(String a, String b, String c){
        if(a.length() > 1 && a.charAt(0) == '0'){
            return false;
        }
        if(b.length() > 1 && b.charAt(0) == '0'){
            return false;
        }
        BigInteger ab = new BigInteger(a);
        BigInteger bb = new BigInteger(b);
        String s = ab.add(bb).toString();
        if(s.equals(c)){
            return true;
        }
        else if(c.length() < s.length() || !s.equals(c.substring(0,s.length()))){
            return false;
        }
        return check(b, s, c.substring(s.length()));
    }

}

public class AdditiveNumber{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.isAdditiveNumb(args[0]));
        //System.out.println(s.isAdditiveNumber(args[0]));
	}
}
