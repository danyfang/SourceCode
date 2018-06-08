//Leetcode problem 793 Preimage Size of Factorial Zeroes Function
//Solution written by Xuqiang Fang on 6 June, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public int preimageSizeFZF(int K){
        return (int)(binarySearch(K) - binarySearch(K-1)); 
    }

    private long binarySearch(int K){
        long l = 0;
        long r = 5L*(K+1);
        while(l <= r){
            long m = l + (r - l) / 2;
            long k = numTrailingZeroes(m);
            if(k <= K){
                l = m + 1;
            }
            else{
                r = m - 1;
            }
        }
        return r;
    }
    private long numTrailingZeroes(long x){
        long ans = 0;
        for(; x > 0; x/=5){
            ans += x/5;
        }
        return ans;
    }
}

public class FactorialZeroes{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.preimageSizeFZF(Integer.parseInt(args[0])));
	}
}
