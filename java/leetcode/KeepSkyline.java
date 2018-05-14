//Leetcode problem 807 Max Increase to Keep City Skyline
//Solution written by Xuqiang Fang on 14 May, 2018
class Solution{
    public int maxIncreasekeepingSkyline(int[][] grid){
        int[] row = new int[grid.length];
        int[] col = new int[grid[0].length];
        for(int i=0; i<row.length; ++i){
            for(int j=0; j<col.length; ++j){
                row[i] = Math.max(row[i], grid[i][j]);
            }
        }
        for(int j=0; j<col.length; ++j){
            for(int i=0; i<row.length; ++i){
                col[j] = Math.max(col[j], grid[i][j]);
            }
        }
        
        int sum = 0;
        for(int i=0; i<row.length; ++i){
            for(int j=0; j<col.length; ++j){
                sum += Math.min(row[i], col[j]) - grid[i][j]; 
            }
        }
        return sum;
    }
}

public class KeepSkyline{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] grid = {{3, 0, 8, 4}, 
                        {2, 4, 5, 7},
                        {9, 2, 6, 3},
                        {0, 3, 1, 0}};
        System.out.println(s.maxIncreasekeepingSkyline(grid));
	}
}
