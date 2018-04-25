//Leetcode problem 419 Battleships in a Board
//Solution written by Xuqiang Fang on 24 April, 2018 

class Solution{
    public int countBattleships(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0)
            return 0;
        int m = board.length;
        int n = board[0].length;
        int count = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(board[i][j] == 'X'){
                    if(!(i-1>=0 && board[i-1][j]=='X'||j-1>=0 && board[i][j-1]=='X')){
                        count++;
                        System.out.println( "x = " + i + " y = " + j);
                    }
                }
            }
        }
        return count;
    }	
}

public class BattleShips{
	public static void main(String[] args){
		Solution s = new Solution();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(s.countBattleships(board));
	}
}
