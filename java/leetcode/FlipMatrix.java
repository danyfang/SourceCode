//Leetcode problem 861 Score After Flipping Matrix
//Solution written by Xuqiang Fang on 2 Junly, 2018
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
    public int matrixScore(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        for(int i=0; i<m; ++i){
            if(A[i][0] == 0){
                for(int j=0; j<n; ++j){
                    A[i][j] = 1 - A[i][j];
                }
            }
        }
        for(int j=0; j<n; ++j){
            int c = 0;
            for(int i=0; i<m; ++i){
                if(A[i][j] == 1){
                    c++;
                }
            }
            if(c < (m+1)/2){
                for(int x=0; x<m; ++x){
                    A[x][j] = 1 - A[x][j];
                }
            }
        }
        int s = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(A[i][j] == 1){
                    s += (int)Math.pow(2, n-1-j);
                }
            }
        }
        return s;
    }
}

public class FlipMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(s.matrixScore(A));
	}
}
