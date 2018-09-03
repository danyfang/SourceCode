//Leetcode problem 898 Bitwise ORs of Subarrays
//Solution written by Xuqiang Fang on 2 Sep, 2018
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
class Solution {
    public int subarrayBitwiseORs(int[] A) {
        int n = A.length;
        Set<Integer> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        Set<Integer> next = new HashSet<>();
        ans.add(A[0]);
        set.add(A[0]);
        for(int i=1; i<n; ++i){
            next.add(A[i]);
            ans.add(A[i]);
            for(int j : set){
                next.add(j | A[i]);
                ans.add(j | A[i]);
            }
            set = next;
            next = new HashSet<>();
        }
        return ans.size();
    }
}
public class BitwiseSubarrays{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,2,3};
        System.out.println(s.subarrayBitwiseORs(A));
	}
}
