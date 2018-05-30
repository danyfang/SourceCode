//Leetcode problem 826 Most Profit Assigning Work
//Solution written by Xuqiang Fang on 29 May, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.Comparator;
class Solution{
    // the idea is to store the max profit with each at most difficulty i
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] a = new int[n][2];
        for(int i=0; i<n; ++i){
            a[i][0] = difficulty[i];
            a[i][1] = profit[i];
        }
        Arrays.sort(a, new com());
        int m = a[0][1];
        for(int i=1; i<n; ++i){
            m = Math.max(m, a[i][1]);
            a[i][1] = m;
        }
        int ans = 0;
        for(int w : worker){
            ans += binarySearch(a, w);
        }
        return ans;
    }
    private int binarySearch(int[][] a, int i){
        int l = 0;
        int r = a.length-1;
        if(a[r][0] <= i){
            return a[r][1];
        }
        else if(a[l][0] > i){
            return 0;
        }
        while(l < r){
            if(l == r-1){
                return a[l][1];
            }
            int m = l + (r - l) / 2;
            if(a[m][0] == i){
                //System.out.println("here");
                return a[m][1];
            }
            else if(a[m][0] < i){
                l = m;
            }
            else{
                r = m;
            }
        }
        return 0;
    }
    class com implements Comparator<int[]>{
        public int compare(int[] a, int[] b){
            if(a[0] == b[0]){
                return b[1] - a[1];
            } 
            return a[0] - b[0];
        }
    }
}

public class ProfitWork{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] d = {2,4,6,8,10};
        int[] p = {100,20,30,40,50};
        int[] w = {4,5,6,7};
        int[] di = {85,47,57};
        int[] pr = {24,66,99};
        int[] wo = {40,25,25};
        System.out.println(s.maxProfitAssignment(d,p,w));
        System.out.println(s.maxProfitAssignment(di,pr,wo));
	}
}
