//Leetcode problem 407 Trapping Rain Water II
//Solution written by Xuqiang Fang on 30 Aug, 2018
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
    public int trapRainWater(int[][] heightMap) {
        if(heightMap == null || heightMap.length == 0 || heightMap[0].length == 0){
            return 0;
        }
        int ans = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->(a[0]-b[0]));
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] visited = new int[m][n];
        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for(int i=0; i<m; ++i){
            q.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][0] = 1;
            q.offer(new int[]{heightMap[i][n-1], i, n-1});
            visited[i][n-1] = 1;
        }
        for(int i=0; i<n; ++i){
            q.offer(new int[]{heightMap[0][i], 0, i});
            visited[0][i] = 1;
            q.offer(new int[]{heightMap[m-1][i], m-1, i});
            visited[m-1][i] = 1;
        }
        //System.out.println(q.peek()[0]);
        int max = Integer.MIN_VALUE;
        while(!q.isEmpty()){
            int[] t = q.poll();
            max = Math.max(max, t[0]);
            for(int[] d : dir){
                int x = t[1] + d[0];
                int y = t[2] + d[1];
                if(x>=0 && x<m && y>=0 && y<n && visited[x][y] == 0){
                    if(heightMap[x][y] < max){
                        ans += max-heightMap[x][y];
                        q.offer(new int[]{max, x, y});
                    } 
                    else{
                        q.offer(new int[]{heightMap[x][y], x, y});
                    }
                    visited[x][y] = 1;
                }
            }
        }
        return ans;
    }
}

public class TrappingRainWater{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] h = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        System.out.println(s.trapRainWater(h));
        h = new int[][]{{3,10,8,12,2,7,9},{7,1,11,3,8,1,10},
                    {9,7,3,10,2,5,6},{7,11,1,4,6,11,9},
                    {4,5,8,12,3,4,2},{12,2,12,1,5,9,6},
                    {6,5,8,12,4,11,10}
        };
        System.out.println(s.trapRainWater(h));
	}
}
