//Leetcode problem 289 Game of Life
//Solution written by Xuqiang Fang on 21 March 2018 

import java.util.ArrayList;
import java.util.List;
class Solution{
	public void gameOfLife(int[][] board){
		if(board == null)
			return;
		List<Integer[]> list = new ArrayList<>();
		int m = board.length;
		int n = board[0].length;
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(board[i][j] == 1){
					if(liveCells(i,j, board) < 2 || liveCells(i,j,board) > 3){
						list.add(new Integer[]{i,j});
					}
				}
				else if(board[i][j] == 0){
					if(liveCells(i,j,board) == 3){
						list.add(new Integer[]{i,j});
					}
				}
			}
		}	
		for(Integer[] i : list){
			if(board[i[0]][i[1]] == 1){
				board[i[0]][i[1]] = 0;
			}
			else if(board[i[0]][i[1]] == 0){
				board[i[0]][i[1]] = 1;
			}
		}
	}	
	public int liveCells(int x, int y, int[][] board){
		int m = board.length;
		int n = board[0].length;
		int count = 0;
		int[] x_axis = new int[3];
		int[] y_axis = new int[3];
		x_axis[0] = x - 1;
		x_axis[1] = x;
		x_axis[2] = x + 1;
		y_axis[0] = y - 1;
		y_axis[1] = y;
		y_axis[2] = y + 1;
		for(int i=0; i<3; i++){
			for(int j=0; j<3; j++){
				//System.out.print(x_axis[i]);
				//System.out.print(y_axis[j]);
				if((x_axis[i] >=0 && x_axis[i] < m) && (y_axis[j] >=0 && y_axis[j] < n) && !(x_axis[i] == x && y_axis[j] == y) && board[x_axis[i]][y_axis[j]] == 1){
					count++;
				}
			}
		}
		return count;
	}
}

public class GameLife{
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] board = {{1,0,0,1},{0,1,0,1},{0,0,0,1},{1,1,0,0}};
		//print(board);
		s.gameOfLife(board);
		print(board);
	}
	public static void print(int[][] board){
		for(int i=0; i<board.length; i++){
				for(int j=0; j<board[0].length; j++){
					System.out.print(board[i][j]);
				}
				System.out.println("\n");
			}
	}
}
