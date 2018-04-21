//Leetcode problem 374 Guess Number Higher of Lower
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
}

public class GuessNumber{
	public static void main(String[] args){
		Solution s = new Solution(10);

        System.out.println(s.guessNumber(Integer.valueOf(args[0])));
	}
}
