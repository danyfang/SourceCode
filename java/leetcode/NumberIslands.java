//Leetcode problem 200 Number of Islands
//Solution written by Xuqiang Fang on 13 April, 2018 
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
class Axis{
    int x,y;
    Axis(int a, int b){x = a; y = b;}
}
class Solution{
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return 0;
        int n = grid.length;
        int m = grid[0].length;
        Axis[][] board = new Axis[n+2][m+2];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++)
                if(grid[i-1][j-1] == '1')
                    board[i][j] = new Axis(i,j);
        }
        Set<Set<Axis>> set = new HashSet<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(board[i][j] != null){
                    Set<Set<Axis>> temp = new HashSet<>();
                    Set<Axis> union = new HashSet<>();
                    if(!set.isEmpty()){
                        for(Set<Axis> s : set){
                            if(s.contains(board[i-1][j]) || s.contains(board[i][j-1]) || s.contains(board[i+1][j])
                            ||s.contains(board[i][j+1])){
                                union.addAll(s);
                                temp.add(s);
                            }
                        } 
                        union.add(board[i][j]);
                    }
                    else{
                        Set<Axis> s = new HashSet<>();
                        s.add(board[i][j]);
                        set.add(s);
                    }
                    set.removeAll(temp);
                    if(union.size() > 0)
                        set.add(union);
                }
            }
        }
        //System.out.println(set.contains(null));
        return set.size();
    }	
        
    //another much smarter solution, provided by user@wcyz666
    public int numIsland(char[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
      
        int count = 0;
        int n = grid.length;
        int m = grid[0].length;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, n, m);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(char[][] grid, int i, int j, int n, int m){
        if(i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
            return;
        grid[i][j] = '0';
        dfs(grid, i-1, j, n ,m);
        dfs(grid, i, j-1, n ,m);
        dfs(grid, i+1, j, n ,m);
        dfs(grid, i, j+1, n ,m);
    }
}

public class NumberIslands{
	public static void main(String[] args){
		Solution s = new Solution();
        char[][] ch = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0','0'}};
        char[][] ch2 = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(s.numIslands(ch));
        System.out.println(s.numIslands(ch2));
        System.out.println(s.numIsland(ch));
        System.out.println(s.numIsland(ch2));
	}
}
