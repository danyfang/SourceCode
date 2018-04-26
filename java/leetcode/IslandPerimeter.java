//Leetcode problem 463 Island Perimeter
//Solution written by Xuqiang Fang on 26 April, 2018 

class Solution{
    public int islandPerimeter(int[][] grid){
        int ans = 0;
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return ans;

        int m = grid.length;
        int n = grid[0].length;
        
        int[][] board = new int[m+2][n+2];
        for(int i=1; i<m+1; ++i){
            for(int j=1; j<n+1; ++j){
                board[i][j] = grid[i-1][j-1];
            }
        }
        for(int i=0; i<m+2; ++i){
            for(int j=1; j<n+2; ++j){
                if(board[i][j] != board[i][j-1] ){
                    ans++;
                    System.out.println(ans);
                } 
            }
        }
        for(int j=0; j<n+2; ++j){
            for(int i=1; i<m+2; ++i){
                if(board[i][j] != board[i-1][j]){
                    ans++;
                }
            }
        }

        return ans;
    }	

}

public class IslandPerimeter{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println(s.islandPerimeter(grid));
	}
}
