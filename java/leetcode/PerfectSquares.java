//Leetcode problem 279 Perfect Squares
//Solution written by Xuqiang Fang on 18 April, 2018 
import java.util.Arrays;
class Solution{
    public int numSquares(int n){
        while((n & 3) == 0){
            n >>= 2;
        }
        if((n & 7) == 7)
            return 4;
        if(isSquare(n))
            return 1;
        int s = (int)Math.sqrt(n);
        for(int i=1; i<=s; i++){
            if(isSquare(n - i * i))
                return 2;
        }
        return 3;
    }	
    private boolean isSquare(int n){
        return ((int)Math.sqrt(n)) * ((int)Math.sqrt(n)) == n;
    }

    public int dp(int n){
        if(n <= 0)
            return 0;
        int[] arr = new int[n+1];
        Arrays.fill(arr, n);
        arr[0] = 0;
        for(int i=1; i<=n; i++){
            for(int j=1; j*j<=i; j++){
                arr[i] = Math.min(arr[i], arr[i-j*j]+1);
            }
        }
        return arr[n];
    }
}

public class PerfectSquares{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.numSquares(Integer.valueOf(args[0])));
        System.out.println(s.dp(Integer.valueOf(args[0])));
	}
}
