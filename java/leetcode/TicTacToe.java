//Leetcode problem 794 Valid Tic-Tac-Toe State
//Solution written by Xuqiang Fang on 14 June, 2018
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
    public boolean validTicTacToe(String[] board) {
        int turns = 0;
        boolean xwin = false, owin = false;
        int[] rows = new int[3], cols = new int[3];
        int diag = 0, anti = 0;
        for(int i=0; i<3; ++i){
            for(int j=0; j<3; ++j){
                if(board[i].charAt(j) == 'X'){
                    turns++; rows[i]++; cols[j]++;
                    if(i == j){
                        diag++;
                    }
                    if(i+j == 2){
                        anti++;
                    }
                }
                else if(board[i].charAt(j) == 'O'){
                    turns--; rows[i]--; cols[j]--;
                    if(i == j){
                        diag--;
                    }
                    if(i+j == 2){
                        anti--;
                    }
                }
            }
        }

        xwin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
               cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
               diag == 3 || anti == 3;
        owin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
               cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
               diag == -3 || anti == -3;
        if(xwin && turns == 0 || owin && turns == 1){
            return false;
        }
        return (turns == 0 || turns == 1) && (!xwin || !owin);
    }
}

public class TicTacToe{
	public static void main(String[] args){
		Solution s = new Solution();
        String[] board = {"XOX", "O O", "XOX"};
        String[] boar = {"XXX", "   ", "OOO"};
        System.out.println(s.validTicTacToe(board));
        System.out.println(s.validTicTacToe(boar));
	}
}
