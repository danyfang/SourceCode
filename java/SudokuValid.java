//LeetCode problem 36, check if a given sudoku is valid
//solution written by Xuqiang Fang on 22, Feb, 2018
import java.util.HashSet;
import java.lang.Character;
class Solution {
    public boolean isValidSudoku(char[][] board) {
		for(int i=0; i<board.length; i++){
			//System.out.println(board[i]);
			if(!this.isValidUnit(board[i]) || !this.isValidUnit(this.getColumn(board,i))
				|| !this.isValidUnit(this.getUnit(board,i))){
				return false;
			}
		}
        return true;
    }
	public boolean isValidUnit(char[] unit){
		for(int i =0; i<unit.length; i++){
			for(int j=i+1; j<unit.length; j++){
				if(unit[i] != '.' && unit[j] != '.' && unit[i] == unit[j]){
					return false;
				}
			}
		}
		return true;
	}
	public char[] getColumn(char[][] sudoku, int index){
		char[] column = new char[9];
		for(int i=0; i<sudoku.length; i++){
			column[i] = sudoku[i][index];	
		}
		return column;
	}
	public char[] getUnit(char[][] sudoku, int index){//index = 0....8
		int srow = index/3;
		int scol = index%3;
		char[] unit = new char[9];
		for(int i=0; i<unit.length; i++){
			int row = srow*3+i/3;
			int col = scol*3+i%3;
			unit[i] = sudoku[row][col]; 
			//System.out.println(unit[i]);
		}
		return unit;
	}
	


	//another solution use hashset to solve it
	public boolean isValidSudoku_HashSet(char[][] board){
		for(int i=0;i<9; i++){
			HashSet<Character> rows = new HashSet<>();
			HashSet<Character> cols = new HashSet<>();
			HashSet<Character> cube = new HashSet<>();
			for(int j=0; j<9; j++){
				if(board[i][j] != '.' && !rows.add(board[i][j])){
					return false;
				}
				if(board[j][i] != '.' && !cols.add(board[j][i])){
					return false;
				}
				int cubeRow = 3*(i/3) + j/3;
				int cubeCol = 3*(i%3) + j%3; 
				if(board[cubeRow][cubeCol] != '.' && !cube.add(board[cubeRow][cubeCol])){
					return false;
				}
			}
		}
		return true;
	}
}

public class SudokuValid{
	public static void main(String[] args){
		char[][] sudoku = {{'5','3','.','.','7','.','.','.','.'},
						   {'6','.','.','1','9','5','.','.','.'},
						   {'.','9','8','.','.','.','.','6','.'},
						   {'8','.','.','.','6','.','.','.','3'},
						   {'4','.','.','8','.','3','.','.','1'},
						   {'7','.','.','.','2','.','.','.','6'},
						   {'.','6','.','.','.','.','2','8','.'},
						   {'.','.','.','4','1','9','.','.','5'},
						   {'.','.','.','.','8','.','.','7','9'}};
		Solution s = new Solution();
		System.out.println(s.isValidSudoku(sudoku));
		System.out.println(s.isValidSudoku_HashSet(sudoku));
	}
}
