//Leetcode problem  827 Making A Large Island
//Solution written by Xuqiang Fang on 18 May, 2018
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
class Solution{
    public int largestIsland(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int color = 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 1){
                    Set<int[]> visited = new HashSet<>();
                    int region = dfs(grid, m, n, i, j, visited);
                    map.put(color, region);
                    for(int[] v : visited){
                        grid[v[0]][v[1]] = color;
                    }
                    color++;
                }
            }
        }
        int area = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(grid[i][j] == 0){
                    Set<Integer> neighbor = new HashSet<>();
                    if(i-1 >= 0 && grid[i-1][j] >= 2){
                        neighbor.add(grid[i-1][j]);
                    }
                    if(i+1 < m && grid[i+1][j] >= 2){
                        neighbor.add(grid[i+1][j]);
                    }
                    if(j-1 >= 0 && grid[i][j-1] >= 2){
                        neighbor.add(grid[i][j-1]);
                    }
                    if(j+1 < n && grid[i][j+1] >= 2){
                        neighbor.add(grid[i][j+1]);
                    }
                    int temp = 1;
                    for(int key : neighbor){
                        temp += map.get(key);
                    }
                    area = Math.max(area, temp);
                }
            }
        }
        if(area == 0){
            return m * n;
        }
        return area;
    }
    private int dfs(int[][] grid, int m, int n, int i, int j, Set<int[]> visited){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0){
            return 0;
        }
        grid[i][j] = 0;
        visited.add(new int[]{i,j});
        int left = dfs(grid, m, n, i-1, j, visited);
        int right = dfs(grid, m, n, i+1, j, visited);
        int up = dfs(grid, m, n, i, j-1, visited);
        int down = dfs(grid, m, n, i, j+1, visited);
        return 1 + left + right + up + down;
    }
}

public class MakingIsland{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] grid = {{1,1,1},{1,0,1},{1,1,1}};
        int[][] g = {
            {0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 1, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {0, 1, 0, 0, 1, 0, 0},
            {0, 1, 1, 1, 1, 0, 0}
        };
        System.out.println(s.largestIsland(g));
	}
}
