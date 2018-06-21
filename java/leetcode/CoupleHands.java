//Leetcode problem 765 Couples Holding Hands
//Solution written by Xuqiang Fang on 20 June, 2018
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
    //a similar but simpler problem 
    public int minSwapsArray(int[] row){
        int n = row.length;
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=row[i]; j!=i; j=row[i]){
                swap(row, i, j);
                ans++;
            }
        }
        return ans;
    }
    public int minSwapsCouples(int[] row) {
        int n = row.length;
        int[] ptn = new int[n];
        int[] pos = new int[n];
        for(int i=0; i<n; ++i){
            ptn[i] = (i%2 == 0) ? i+1:i-1;
            pos[row[i]] = i;
        }
        int ans = 0;
        for(int i=0; i<n; ++i){
            for(int j=ptn[pos[ptn[row[i]]]]; j!=i; j=ptn[pos[ptn[row[i]]]]){
                swap(row, i, j);
                swap(pos, row[i], row[j]);
                ans++;
            }
        }
        return ans;
    }
    private void swap(int[] row, int i, int j){
        int t = row[i];
        row[i] = row[j];
        row[j] = t;
    }
}

public class CoupleHands{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] row = {0,2,1,3};
        int[] ro = {3,2,0,1};
        System.out.println(s.minSwapsCouples(row));
        System.out.println(s.minSwapsCouples(ro));
	}
}
