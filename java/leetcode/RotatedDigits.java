//Leetcode problem 788 Rotated Digits
//Solution written by Xuqiang Fang on 6 May, 2018 
/*
1-9 6
10-99 3*10+6*3+2*3=54
100-999 3*100+6*30+6*7*3+2*3*3=624
1000-9999 3*1000+6*300+6*7*30+6*7*7*3+2*3*3*3=6996
10000-99999 3*10000+6*3000+6*7*300+6*7*7*30+6*7*7*7*3+2*3*3*3*3=75756

*/
class Solution{
    //N is in range [1, 100000]
    public int rotatedDigits(int N){
        int[] unit = {0,0,1,1,1,2,3,3,3,4};
        int[] dp = new int[N+1];
        int count = 0;
        for(int i=0; i<=N; ++i){
            if(i < 10){
                if(i==0 || i==1 || i==8)
                    dp[i] = 1;
                else if(i ==2 || i==5 || i== 6 || i==9){
                    dp[i] = 2;
                    count++;
                }
            }
            else{
                int a = dp[i/10];
                int b = dp[i%10];
                if(a == 1 && b == 1)
                    dp[i] = 1;
                else if(a >= 1 && b >= 1){
                    dp[i] = 2;
                    count++;
                }
            }
        }
        return count;
    }
}

public class RotatedDigits{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.rotatedDigits(Integer.valueOf(args[0])));
	}
}
