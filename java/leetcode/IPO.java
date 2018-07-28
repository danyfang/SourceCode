//Leetcode problem 502 IPO
//Solution written by Xuqiang Fang on 26 July, 2018
import java.util.ArrayList;
import java.util.List;
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
    //this solution TLE
    public int findMaximizedCapital_(int k, int W, int[] Profits, int[] Capital) {
        int n = Capital.length;
        int[][] pc = new int[n][3];
        for(int i=0; i<n; ++i){
            pc[i][0] = Capital[i];
            pc[i][1] = Profits[i];
        }
        Arrays.sort(pc, new Comparator<int[]>(){
            @Override
            public int compare(final int[] a, final int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        while(k-- > 0){
            int l = 0;
            int r = n;
            while(l < r){
                int m = l + (r - l)/2;
                if(pc[m][0] <= W){
                    l = m + 1;
                }
                else{
                    r = m;
                }
            }
            int max = -1;
            int index = l;
            for(int i=0; i<l; ++i){
                if(pc[i][2] == 0 && pc[i][1] > max){
                    max = pc[i][1];
                    index = i;
                }
            }
            if(max == -1){
                break;
            }
            else{
                pc[index][2] = 1;
                W += max;
            }
        }
        return W;
    }

    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital){
        int n = Capital.length;
        int[][] pc = new int[n][2];
        for(int i=0; i<n; ++i){
            pc[i][0] = Capital[i];
            pc[i][1] = Profits[i];
        }
        Arrays.sort(pc, new Comparator<int[]>(){
            @Override
            public int compare(final int[] a, final int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int curr = 0;
        while(k-- > 0){
            while(curr < n && pc[curr][0] <= W ){
                map.put(pc[curr][1], map.getOrDefault(pc[curr][1], 0)+1);
                curr++;
            } 
            if(map.isEmpty()){
                break;
            }
            int key = map.lastKey();
            W += key;
            if(map.get(key) == 1){
                map.remove(key);
            }
            else{
                map.put(key, map.get(key)-1);
            }
        }
        return W;
    }
}

public class IPO{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] Profits = {1,2,3};
        int[] Capital = {0,1,1};
        System.out.println(s.findMaximizedCapital(2, 0, Profits, Capital));
	}
}
