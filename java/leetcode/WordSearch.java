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
        char[] ch = word.toCharArray();
        boolean result = false;
        for(int i=0; i<row; ++i){
            for(int j=0; j<col; ++j){
                if(board[i][j] == ch[0]){
                    //System.out.println("i = " + i + " j = " + j);
                    result = dfs(board, ch, 0, i, j);
                }
                if(result){
                    return true;
                }
            }
        }
		return false;
	}
    private boolean dfs(char[][] board, char[] word, int index, int x, int y){
        if(index == word.length){
            //System.out.println("here at position " + "(" + x + "," + y + ")" );
            return true;
        }
        if(x<0 || x>=board.length || y<0 || y>=board[0].length || index > word.length
            || board[x][y] != word[index])
            return false;

        //System.out.println("now search for " + index + "th char " + word[index] + " at position " + "(" + x + "," + y + ")");
        board[x][y] = '0';
        boolean exist = dfs(board, word, index+1, x-1, y) || dfs(board, word, index+1, x+1, y) ||dfs(board, word, index+1, x, y-1) || dfs(board, word, index+1, x, y+1);

        board[x][y] = word[index];
        return exist;
    }

}

public class WordSearch{
	public static void main(String[] args){
		Solution s = new Solution();
		char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        print(board);
		String word = "SEE";
		System.out.println(s.exist(board, word));
		System.out.println(s.exist(board, "ABCCED"));
		System.out.println(s.exist(board, "ABCB"));
	}

	public static void print(char[][] ch){
		for(int i=0; i<ch.length; i++){
            for(int j=0; j<ch[0].length; ++j)
			    System.out.print(ch[i][j] + "\t");
            System.out.println("\n");
		}
	}
}
