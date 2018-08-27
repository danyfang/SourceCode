//Leetcode problem 892 Surface Area of 3D Shapes
//Solution written by Xuqiang Fang on 27 Aug, 2018
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
    public int surfaceArea(int[][] grid) {
        int ans = 0;
        int count = 0;
        int N = grid.length;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                ans += grid[i][j] * 4;
                if(grid[i][j] > 0){
                    ans += 2;
                }
                if(j > 0){
                    ans -= Math.min(grid[i][j], grid[i][j-1]) * 2;
                }
                if(i > 0){
                    ans -= Math.min(grid[i][j], grid[i-1][j]) * 2;
                }
            }
        }
        return ans;
    }
}

public class SurfaceArea{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] grid = {{2}};
        System.out.println(s.surfaceArea(grid));
        grid = new int[][]{{1,2},{3,4}};
        System.out.println(s.surfaceArea(grid));
        grid = new int[][]{{1,0},{0,2}};
        System.out.println(s.surfaceArea(grid));
        grid = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        System.out.println(s.surfaceArea(grid));
        grid = new int[][]{{2,2,2},{2,1,2},{2,2,2}};
        System.out.println(s.surfaceArea(grid));
	}
}
