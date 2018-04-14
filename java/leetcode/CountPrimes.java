//Leetcode problem 204 Count Primes
//Solution written by Xuqiang Fang on 13 April, 2018 
import java.util.Arrays;
class Solution{
    //This solution exceeded time limit
    public int countPrimes(int n){
        int count = 0;
        for(int i=2; i<n; i++){
            if(isPrime(i))
                count++;
        } 
        return count;
    }	
    private boolean isPrime(int n){
        if(n == 2|| n == 3)
            return true;
        if(n == 1|| n % 2 == 0)
            return false;
        for(int i=3; i*i<=n; i+=2){
            if(n % i == 0)
                return false;
        }
        return true;
    }
    public int count(int n){
        int c = 0;
        boolean[] arr = new boolean[n];
        Arrays.fill(arr, true);
        for(int i=2; i*i<n; i++){
            if(arr[i]){
                for(int j=i*i; j<n; j+=i)
                    arr[j] = false;
            }
        }
        for(int i=2; i<n; i++){
            if(arr[i])
                c++;
        }
        return c;
    }
}

public class CountPrimes{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.count(Integer.valueOf(args[0])));
	}
}
