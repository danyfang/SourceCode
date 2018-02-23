/*
this program is written by Xuqiang Fang on Feb 13th, 2018 
to solve the sudoku problem. 
only primary sudoku can be solved using this program
*/
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;

class Solution {
    public void solveSudoku(char[][] board) {
    	int Nsolution = 1;
    	int size = this.finished(board);
	//System.out.println(size);
	boolean flag = false;
    	while(size>0){
		flag = false;// each scan, set flag to false to monitor progress
		Nsolution = 1;
		for(int i=0;i<board.length;i++){
       			for(int j=0;j<board[0].length;j++){
				if(board[i][j] == '.'){
					String[] temp = this.legalChar(i,j,board);
					if(temp.length == Nsolution){
						flag = true;
						size--;
						board[i][j] = temp[0].toCharArray()[0]; 
						continue;
					}
				}	
			}
       		}
	}
    }
    public int finished(char[][] board){
    	int size_board = 0;
    	for(int i=0; i<board.length; i++){
		for(int j=0; j<board[0].length; j++){
			if(board[i][j] == '.'){
				size_board++;
			}
		}
	}
	return size_board;
    }
    public String[] legalChar(int x, int y, char[][] board){
	ArrayList<String> original = new ArrayList<String>(Arrays.
	asList("1","2","3","4","5","6","7","8","9"));
	//first, check the row;
	for(int i=0; i<board[x].length; i++){
		if(board[x][i] != '.'){
			original.remove(String.valueOf(board[x][i]));
		}
	}
	//check the column
	for(int i=0; i<board[0].length;i++){
		if(board[i][y] != '.'){
			original.remove(String.valueOf(board[i][y]));
		}
	}
	//check the square;
	for(int i=(x/3)*3; i<(x/3+1)*3; i++){
		for(int j=(y/3)*3; j<(y/3+1)*3;j++){
			if(board[i][j] != '.'){
				original.remove(String.valueOf(board[i][j]));
			}
		}
	}
	/*
	for(int i=0; i<original.size();i++){
		System.out.println(original.toArray()[i]);	
	}
	*/
	String newString[] = original.toArray(new String[0]);
	return  newString;
    }
}

public class Sudoku{
	public static void main(String[] args){
		Solution s = new Solution();
		char[][] input = {{'5','3','.','.','7','.','.','.','.'},
		{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},
		{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},
		{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},
		{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
		/*
		String[][] str = [[".",".","9","7","4","8",".",".","."],
		["7",".",".",".",".",".",".",".","."],[".","2",".","1",".","9",".",".","."],
		[".",".","7",".",".",".","2","4","."],[".","6","4",".","1",".","5","9","."],
		[".","9","8",".",".",".","3",".","."],[".",".",".","8",".","3",".","2","."],
		[".",".",".",".",".",".",".",".","6"],[".",".",".","2","7","5","9",".","."]];
		*/
		char[][] sinput = {{'.','.','9','7','4','8','.','.','.'},
		{'7','.','.','.','.','.','.','.','.'},{'.','2','.','1','.','9','.','.','.'},
		{'.','.','7','.','.','.','2','4','.'},{'.','6','4','.','1','.','5','9','.'},
		{'.','9','8','.','.','.','3','.','.'},{'.','.','.','8','.','3','.','2','.'},
		{'.','.','.','.','.','.','.','.','6'},{'.','.','.','2','7','5','9','.','.'}
		};
		char[][] tinput = {{'.', '.', '9', '7', '4', '8', '.', '.', '.'}, 
		{'7', '.', '.', '.', '.', '.', '.', '.', '.'}, {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
		{'.', '.', '7', '.', '.', '.', '2', '4', '.'}, {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
		{'.', '9', '8', '.', '.', '.', '3', '.', '.'}, {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
		{'.', '.', '.', '.', '.', '.', '.', '.', '6'}, {'.', '.', '.', '2', '7', '5', '9', '.', '.'}};
		print_board(input);
		String[] res = s.legalChar(2,2,tinput); 
		//System.out.println(res.length);
		s.solveSudoku(input);
		System.out.println("+++++++++++++");
		print_board(input);
	}
	public static void print_board(char[][] board){
		for(int i=0; i<board.length;i++){
			for(int j=0; j<board[i].length; j++){
				System.out.print(board[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}
}
