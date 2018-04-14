//Leetcode problem 201 Bitwise AND of Numbers Range
//Solution written by Xuqiang Fang on 13 April, 2018 

class Solution{
    //This solution is toooooo slow
    public int rangeBitwiseAnd(int m, int n) {
        int result = 2147483647;
        for(int i=m; i<=n; i++)
            result &= i;
    
        return result;
    }	
    public int range(int m, int n){
        return (n > m) ? (rangeBitwiseAnd(m/2, n/2) << 1) : m;
    }

    public int r(int m, int n){
        int moveFactor = 1;
        while(m != n){
            m >>= 1;
            n >>= 1;
            moveFactor <<= 1;
        }
        return m * moveFactor;
    }
}

public class BitwiseAndRange{
	public static void main(String[] args){
		Solution s = new Solution();
        //System.out.println(s.range(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
        System.out.println(s.r(Integer.valueOf(args[0]), Integer.valueOf(args[1])));
	}
}
