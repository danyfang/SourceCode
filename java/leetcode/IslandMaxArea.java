//Leetcode problem 695 Max Area of Island
//Solution written by Xuqiang Fang on 4 May, 2018
class Solution{
    public int maxAreaOfIsland(int[][] grid){
        int max = 0;
        for(int i=0; i<grid.length; ++i){
            for(int j=0; j<grid[0].length; ++j){
                if(grid[i][j] == 1){
                    max = Math.max(max, area(grid, i, j));
                }
            }
        }
        return max;
    }

    private int area(int[][] grid, int i, int j){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + area(grid, i-1,j) + area(grid,i+1,j) + area(grid, i,j-1) + area(grid,i,j+1);
        }
        return 0;
    }
}

public class IslandMaxArea{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}};
        System.out.println(s.maxAreaOfIsland(grid));
	}
}
