//Leetcode problem 900 RLE Iterator
//Solution written by Xuqiang Fang on 9 Sep, 2018
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
class RLEIterator{
    long[] sum;
    int[] copy;
    long curr;
    long max;
    public RLEIterator(int[] A) {
        copy = A;
        int n = A.length;
        sum = new long[n/2];
        sum[0] = A[0];
        for(int i=1; i<sum.length; ++i){
            sum[i] = sum[i-1] + A[2*i]; 
        }
        max = sum[sum.length-1];
        curr = 0;
    }
    
    public int next(int n) {
        curr += (long)n;
        //System.out.println(curr);
        if(curr > max){
            return -1;
        }
        int l = 0;
        while(curr > sum[l]){
            l++;
        }
        return copy[2*l+1];
    }
}

public class RLEIteratorImp{
	public static void main(String[] args){
        int[] A = {3,8,0,9,2,5};
		RLEIterator s = new RLEIterator(A);
        System.out.println(s.next(2));
        System.out.println(s.next(1));
        System.out.println(s.next(1));
        System.out.println(s.next(1));
        System.out.println(s.next(2));
	}
}
