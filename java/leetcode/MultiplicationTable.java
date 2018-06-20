//Leetcode problem 668 Kth Smallest Number in Multiplication Table
//Solution written by Xuqiang Fang on 19 June, 2018
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
    public int findKthNumber(int m, int n, int k) {
        int l = 0;
        int r = m * n  + 1;
        while(l <= r){
            int mid = (l + r) / 2;
            int total = 0, j = n;
            int ans = 0;
            for(int i=1; i<=m; ++i){
                while(j >= 1 && i * j > mid){
                    --j;
                }
                total += j;
                if(j == 0){
                    break;
                }
                if(i * j > ans){
                    ans = i * j;
                }
            }
            if (total == k || l == r){
                return ans;
            }
            else if (total > k){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        throw null;
    }
}

public class MultiplicationTable{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.findKthNumber(2,3,6));
        System.out.println(s.findKthNumber(232,3424,6422));
	}
}
