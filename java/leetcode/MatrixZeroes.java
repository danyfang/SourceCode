//Leetcode problem 73 Set Matrix Zeroes
//Solution written by Xuqiang Fang on 20 March 2018 
/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0.
Do it in place.
*/
//Solution accepted, use O(m+n) space
//Another solution which uses O(1) sapce is to store info for each row at the beginning of each row and info for each column at the beginning of each column.
import java.util.ArrayList;
import java.util.List;
class Solution{
	public void setZeroes(int[][] matrix){
		if(matrix == null)
			return;
		int m = matrix.length;
		int n = matrix[0].length;
		List<Integer[]> list = new ArrayList<Integer[]>();
		for(int i=0; i<m; i++){
			for(int j=0; j<n; j++){
				if(matrix[i][j] == 0){
					list.add(new Integer[]{i,j});
				}
			}
		}
		for(Integer[] l : list){
			for(int j=0; j<n; j++){
				matrix[l[0]][j] = 0;
			}
			for(int i=0; i<m; i++){
				matrix[i][l[1]] = 0;
			}
		}
	}	
}

public class MatrixZeroes{
	public static void main(String[] args){
		Solution s = new Solution();
	}
}
