//Leetcode problem 778 Swim in Rising Water
//Solution written by Xuqiang Fang on 20 May, 2018
class Solution{
    //method 1, brutal force and it got accepted, yeah
    public int swimInWater(int[][] grid) {
        int N = grid.length; 
        for(int i=2*N-2; i<=N*N-1; ++i){
            if(dfs(grid, i, 0, 0, N)){
                return i;
            }
            else{
                reset(grid);
                //print(grid);
            }
        }
        return N;
    }
    private void reset(int[][] grid){
        int N = grid.length;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(grid[i][j] >=N*N){
                    grid[i][j] -= N*N;
                }
            }
        }
    }
    /*
    private void print(int[][] grid){
        int N = grid.length;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println("\n");
        }
    }
    */
    private boolean dfs(int[][] grid, int t, int x, int y, int N){
        if(x<0 || x>=N || y<0 || y>=N || grid[x][y] > t){
            return false;
        } 
        else if(x == N-1 && y == N-1){
            return true;
        }
        grid[x][y] += N * N ;
        if(dfs(grid, t, x-1, y, N)){
            return true;
        }
        if(dfs(grid, t, x+1, y, N)){
            return true;
        }
        if(dfs(grid, t, x, y-1, N)){
            return true;
        }
        if(dfs(grid, t, x, y+1, N)){
            return true;
        }
        return false;
    }
}

public class RisingWater{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
        System.out.println(s.swimInWater(grid));
	}
}
