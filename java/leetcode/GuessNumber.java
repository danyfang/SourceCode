//Leetcode problem 374 Guess Number Higher of Lower
//Leetcode problem 375 Guess Number Higher of Lower II
//Solution written by Xuqiang Fang on 18 April, 2018 
class GuessGame{
    private int real = 0;
    public GuessGame(int n){
        this.real = n;
    }
    public int guess(int num){
        if(num > this.real)
            return 1;
        else if(num < this.real)
            return -1;
        return 0;
    }
    public int get(){
        return this.real;
    }
}
class Solution extends GuessGame{
    public Solution(int real){
        super(real);
    }

    public int guessNumber(int n) {

        int real = Integer.MAX_VALUE;

        if(guess(real) == 0)
            return real;
        while(guess(real) == -1){
            real = real / 2;
        }
        return search(n, 2*real);
    }
    
    private int search(int n, int r){
        if(guess(r) == 0)
            return r;
        if(guess(n) == 0)
            return n;
        if(guess(n) == -1){
            int mid = 1 + (n - 1) / 2;
            if(guess(mid) == 0)
                return mid;
            if(guess(mid) == -1)
                return search(1, mid-1);
            return search(mid+1, n);
        }
        if(guess(n) == 1){
            int mid = n + (r - n) / 2;
            if(guess(mid) == 0)
                return mid;
            if(guess(mid) == 1)
                return search(mid+1, r);
            return search(n, mid-1);
        }
        return -1;
    }


    //Problem 375 Guess Number Higher or Lower II
    //use dynamic programming
    //dp[i][j] means the minimum cost for range(i,j);
    public int getMoneyAmount(int n){
        int[][] table = new int[n+1][n+1];
        return dp(table, 1, n);
    }
    public int dp(int[][] table, int s, int e){
        if(s >= e)
            return 0;
        if(table[s][e] != 0)
            return table[s][e];
        int res = Integer.MAX_VALUE;
        for(int x=s; x<=e; ++x){
            int temp = x + Math.max(dp(table, s, x-1), dp(table, x+1, e));
            res = Math.min(res, temp);
        }
        table[s][e] = res;
        return res;
    }

    public int getMoney(int n) {
        int[][] table = new int[n+1][n+1];
        for(int j=2; j<=n; j++){
            for(int i=j-1; i>0; i--){
                int globalMin = Integer.MAX_VALUE;
                for(int k=i+1; k<j; k++){
                    int localMax = k + Math.max(table[i][k-1], table[k+1][j]);
                    globalMin = Math.min(globalMin, localMax);
                }
                table[i][j] = i+1==j?i:globalMin;
            }
        }
        return table[1][n];
    }
    
}

public class GuessNumber{
	public static void main(String[] args){
		Solution s = new Solution(10);

        System.out.println(s.getMoney(Integer.valueOf(args[0])));
	}
}
