//Leetcode problem  837 New 21 Game
//Solution written by Xuqiang Fang on 20 May, 2018
class Solution{
    /*
    dp[i]: probability of get points i
    dp[i] = sum(last W dp values) / W
    */
    public double new21Game(int N, int K, int W) {
        if(K == 0 || N >= K + W){
            return 1.0;
        }
        double[] p = new double[N+1];
        p[0] = 1.0;
        double s = 1.0;
        double ans = 0.0;
        for(int i=1; i<=N; ++i){
            p[i] = s/W; 
            if(i < K){
                s += p[i];
            }
            else{
                ans += p[i];
            }

            if(i >= W){
                s -= p[i-W];
            }
        }
        return ans;
    }
}

public class TwentyOneGame{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.new21Game(10, 1, 10));
        System.out.println(s.new21Game(6, 3, 10));
        System.out.println(s.new21Game(21, 17, 10));
	}
}
