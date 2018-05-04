//Leetcode problem 130 Surrounded Regions
//Solution written by Xuqiang Fang on 4 May, 2018
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
class Solution{
    public void solve(char[][] board){
        if(board == null || board.length == 0 || board[0].length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        Set<ArrayList<Integer>> tmp = new HashSet<>();
        Set<ArrayList<Integer>> set = new HashSet<>();
        for(int i=0; i<m; ++i){
            if(board[i][0] == 'O'){
                ArrayList<Integer> axis = new ArrayList<>();
                axis.add(i);
                axis.add(0);
                tmp.add(axis);
            }
            if(board[i][n-1] == 'O'){
                ArrayList<Integer> axis = new ArrayList<>();
                axis.add(i);
                axis.add(n-1);
                tmp.add(axis);
            }
        }
        for(int j=1; j<n-1; ++j){
            if(board[0][j] == 'O'){
                ArrayList<Integer> axis = new ArrayList<>();
                axis.add(0);
                axis.add(j);
                tmp.add(axis);
            }
            if(board[m-1][j] == 'O'){
                ArrayList<Integer> axis = new ArrayList<>();
                axis.add(m-1);
                axis.add(j);
                tmp.add(axis);
            }
        }
        set.addAll(tmp);
        for(ArrayList<Integer> bound : tmp){
            dfs(board, set, bound.get(0), bound.get(1));
        }
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j] == 'O' ){
                    board[i][j] = 'X';
                }
            }
        }

        for(ArrayList<Integer> bound : set){
            board[bound.get(0)][bound.get(1)] = 'O';
        }
    }

    private void dfs(char[][] board, Set<ArrayList<Integer>> tmp, int x, int y){
        if(x<0 || x>=board.length || y<0 ||y>=board[0].length || board[x][y] == 'X')
            return;
        else {
            ArrayList<Integer> axis = new ArrayList<>();
            axis.add(x);
            axis.add(y);
            if(!tmp.contains(axis))
                tmp.add(axis);
            board[x][y] = 'X';
            dfs(board, tmp, x-1, y);
            dfs(board, tmp, x+1, y);
            dfs(board, tmp, x, y-1);
            dfs(board, tmp, x, y+1);
        }
    }
}

public class SurroundedRegions{
	public static void main(String[] args){
		Solution s = new Solution();
        char[][] board = {{'X','X','X','X'},{'X','X','O','X'},{'X','O','X','X'},{'X','O','X','X'}};
        char[][] boar = {{'O','O','O'},{'O','O','O'},{'O','O','O'}};
        for(char[] b : boar){
            for(char c : b){
                System.out.print(c + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("********************");
        s.solve(boar);
        for(char[] b : boar){
            for(char c : b){
                System.out.print(c + "\t");
            }
            System.out.println("\n");
        }

	}
}
