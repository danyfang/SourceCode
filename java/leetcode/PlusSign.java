//Leetcode problem 764 Largest Plus Sign
//Solution written by Xuqiang Fang on 14 May, 2018

import java.util.Arrays;

class Solution{

    //DFS solution TLE
    public int orderOfLargest(int N, int[][] mines) {
        if(mines == null || mines.length == 0 || mines[0].length == 0)
            return (N-1)/2 + 1;
        int[][] matrix = new int[N][N];    
        for(int[] mine : mines){
            matrix[mine[0]][mine[1]] = 1;
        }
        /*
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }
        */

        int res = 0;
        int order = 0;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                if(matrix[i][j] != 1){
                    order = 1;
                    int[] four = new int[4];
                    Arrays.fill(four, 1);
                    dfs(N, matrix, four, i, j, 0);
                    int min = four[0];
                    for(int x : four){
                        //System.out.print( x + "\t" );
                        min = Math.min(min, x);
                    }
                    order = Math.max(min, order);
                    //System.out.println(" order = " + order);
                }
                res = Math.max(order, res);
            }
        }
        return res;
    }
    


    //direction left : (0, -1), right: (0, +1), up: (-1, 0), down: (+1, 0)
    private void dfs(int N, int[][] matrix, int[] order, int x, int y, int direction){
        if(x<0 || x>=N || y<0 || y>= N || matrix[x][y] == 1){
            return;
        } 
       
        switch(direction){
            case 1:
                order[0] += 1;
                dfs(N, matrix, order, x, y-1, 1);
                break;
            case 2:
                if(order[1] <= order[0])
                    order[1] += 1;
                    dfs(N, matrix, order, x, y+1, 2);
                break;
            case 3:
                if(order[2] <= order[1])
                    order[2] += 1;
                    dfs(N, matrix, order, x-1, y, 3);
                break;
            case 4:
                if(order[3] <= order[2])
                    order[3] += 1;
                    dfs(N, matrix, order, x+1, y, 4);
                break;
            case 0:
                //order is left, right, up, down
                dfs(N, matrix, order, x, y-1, 1);
                dfs(N, matrix, order, x, y+1, 2);
                dfs(N, matrix, order, x-1, y, 3);
                dfs(N, matrix, order, x+1, y, 4);
        } 
    }

    //reference from user@fun4LeetCode
    public int orderOfLargestPlusSign(int N, int[][] mines) {
        int[][] grid = new int[N][N];
        for(int i=0; i<N; ++i){
            Arrays.fill(grid[i], N);
        }

        for(int[] mine : mines){
            grid[mine[0]][mine[1]] = 0;
        }

        for(int i=0; i<N; ++i){
            for(int j=0, k=N-1, l=0, r=0, u=0, d=0; j<N; ++j, --k){
                //j is a column index, iterate from left to right
                //every time check how far left it can reach.
                //if grid[i][j] is 0, l needs to start over from 0 again, otherwise increment
                grid[i][j] = Math.min(grid[i][j], l = (grid[i][j] == 0 ? 0 : l+1));
                grid[i][k] = Math.min(grid[i][k], r = (grid[i][k] == 0 ? 0 : r+1));
                grid[j][i] = Math.min(grid[j][i], u = (grid[j][i] == 0 ? 0 : u+1));
                grid[k][i] = Math.min(grid[k][i], d = (grid[k][i] == 0 ? 0 : d+1));
            }
        }

        int res = 0;
        for(int i=0; i<N; ++i){
            for(int j=0; j<N; ++j){
                res = Math.max(res, grid[i][j]);
            }
        }

        return res;
    }
}

public class PlusSign{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] mines = {{0,1}};
        System.out.println(s.orderOfLargestPlusSign(500, mines));
	}
}
