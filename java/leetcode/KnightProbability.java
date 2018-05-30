//Leetcode problem  688 Knight Probability in Chessboard
//Solution written by Xuqiang Fang on 30 May, 2018
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
    public double knightProbability(int N, int K, int r, int c) {
        if(K > 0){
            double p = 0.0;
            for(int[] d : dir){
                if(r+d[0]>=0 && r+d[0]<N && c+d[1]>=0 && c+d[1]<N){
                    if(b[K-1][r+d[0]][c+d[1]] > 0){
                        p += 0.125 * b[K-1][r+d[0]][c+d[1]];
                    }
                    else{
                        p += 0.125 * knightProbability(N, K-1, r+d[0], c+d[1]);
                    }
                }
            }
            b[K][r][c] = p;
            return p;
        }
        return 1.0;
    }
    private int[][] dir = {{-1,2},{-1,-2},{-2,1},{-2,-1},{2,1},{2,-1},{1,2},{1,-2}};
    private double[][][] b = new double[100][25][25];
}

public class KnightProbability{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.knightProbability(3,2,0,0));
        System.out.println(s.knightProbability(8,30,6,4));
	}
}
