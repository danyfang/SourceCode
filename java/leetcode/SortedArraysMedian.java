//Leetcode problem 4 Median of Two Sorted Arrays
//Solution written by Xuqiang Fang on 17 June, 2018
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
    public double findMedianSortedArrays(int[] n1, int[] n2){
        int l1 = n1.length;
        int l2 = n2.length;
        int k = (l1 + l2 + 1) / 2;
        //System.out.println("k = " + k);
        if(l1 > l2){
            return findMedianSortedArrays(n2, n1);
        }
        int l = 0;
        int r = l1;
        while(l < r){
            int m1 = l + (r-l) / 2;
            int m2 = k - m1;
            if(n1[m1] < n2[m2-1]){
                l = m1 + 1;
            }
            else{
                r = m1;
            }
        }
        int m1 = l;
        int m2 = k-m1;

        //System.out.println("l = " + l);
        int c1 = Math.max(m1 <= 0 ? Integer.MIN_VALUE : n1[m1-1], m2 <= 0 ? Integer.MIN_VALUE : n2[m2-1]);
        if((l1+l2)%2 == 1){
            return c1;
        }
        int c2 = Math.min(m1 >= l1 ? Integer.MAX_VALUE : n1[m1], m2 >= l2 ? Integer.MAX_VALUE : n2[m2]);
        //System.out.println("c1 = " + c1 + ", c2 = " + c2);
        return (double)(c1+c2) / 2.0;
    }
}

public class SortedArraysMedian{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] nums1 = {-1,1,3,5,7,9};
        int[] nums2 = {2,4,6,8,10,12,14,16};
        int[] num1 = {2,3};
        int[] num2 = {1,4};
        System.out.println(s.findMedianSortedArrays(num1, num2));
	}
}
