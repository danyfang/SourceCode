//Leetcode problem 79 Word Search
//Solution written by Xuqiang Fang on 05 March 2018
/*
Given a 2D board and a word, find if the word exists in the grid.
The word can be constructed from letters of sequentially adjacent 
cell, where "adjacent" cells are those horizontally or vertically
neighboring. The same letter cell may not be used more than once.
*/


class Solution{
	public boolean exist(char[][] board, String word){
		if(board == null || board.length ==0)
			return false;
		int row = board.length;
		int col = board[0].length;
		return false;
	}

}

public class WordSearch{
	public static void main(String[] args){
		Solution s = new Solution();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		String word = "SEE";
		System.out.println(s.exist(board, word));
		print(board[0]);
	}

	public static void print(char[] ch){
		for(int i=0; i<ch.length; i++){
			System.out.println(ch[i]);
		}
	}
}
