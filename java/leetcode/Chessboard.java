//Leetcode problem 782 Transform to Chessboard
//Solution written by Xuqiang Fang on 4 July, 2018
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Arrays;
class Solution{
    public int movesToChessboard(int[][] b) {
        if(b.length == 0){
            return 0;
        } 
        if(valid(b)){
            return 0;
        }
        int n = b.length;
        return n;
    }
    private boolean valid(int[][] b){
        int n = b.length;
        for(int i=0; i<n; ++i){
            for(int j=0; j<n; ++j){
                if(i >= 1 && b[i][j] == b[i-1][j]){
                    return false;
                }
                if(j >= 1 && b[i][j] == b[i][j-1]){
                    return false;
                } 
            }
        }
        return true;
    }
}

public class Chessboard{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] board = {{0,1,1,0},{0,1,1,0},{1,0,0,1},{1,0,0,1}};
        System.out.println(s.movesToChessboard(board));
        board = new int[][]{{0,1},{1,0}};
        System.out.println(s.movesToChessboard(board));
        board = new int[][]{{1,0},{1,0}};
        System.out.println(s.movesToChessboard(board));
	}
}
