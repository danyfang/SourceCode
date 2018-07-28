//Leetcode problem 805 Split Array With Same Average
//Solution written by Xuqiang Fang on 27 July, 2018
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
    public boolean splitArraySameAverage(int[] A) {
        /**
        From induction we can get 
        S1 = n1*S/n, where S1 is the sum of n1 elements
        S and n are the total sum and total number of elements
        */
        int n = A.length;
        int m = n/2 + 1;
        Set<Integer> [] sum = new HashSet[m];
        for(int i=0; i<m; ++i){
            sum[i] = new HashSet<>();
        }
        sum[0].add(0);
        int total = 0;
        for(int a : A){
            total += a;
            for(int j=m-1; j>=1; --j){
                if(sum[j-1].size() > 0){
                    for(int e : sum[j-1]){
                        sum[j].add(a + e);
                    }
                } 
            }
        }
        for(int i=1; i<m; ++i){
            if(i * total % n == 0 && sum[i].contains(i*total/n)){
                return true;
            }
        }
        return false;
    }
}

public class SplitArrayAverage{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,2,3,4,5,6,7,8};
        System.out.println(s.splitArraySameAverage(A));
	}
}
