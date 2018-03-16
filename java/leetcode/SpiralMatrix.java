//Leetcode problem 54 Spiral Matrix && Spiral Matrix II
//Solution written by Xuqiang Fang on 14 March 2018 
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of
the matrix in spiral order.
*/
//Solution provided by user@qwl5004
import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;
            
            if (colBegin <= colEnd) {
                // Traver Up
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin ++;
        }
        
        return res;
    }
	public int[][] generateMatrix(int n) {
    	int[][] matrix = new int[n][n];
		int rowBegin = 0;
		int rowEnd = n-1;
		int colBegin = 0;
		int colEnd = n-1;
		int i = 1;
		while(rowBegin <= rowEnd && colBegin <= colEnd){
			for(int j=colBegin; j<=colEnd; j++){
				matrix[rowBegin][j] = i++; 
			}
			rowBegin++;
			for(int j=rowBegin; j<=rowEnd; j++){
				matrix[j][colEnd] = i++;
			}
			colEnd--;

			if(rowBegin <= rowEnd){
				for(int j=colEnd; j>= colBegin; j--){
					matrix[rowEnd][j] = i++;
				}
			}
			rowEnd--;

			if(colBegin <= colEnd){
				for(int j=rowEnd; j>=rowBegin; j--){
					matrix[j][colBegin] = i++;
				}
				colBegin++;
			}
		}
		return matrix;
    }
}
public class SpiralMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(s.spiralOrder(matrix));
		print(s.generateMatrix(0));
	}
	public static void print(int[][] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[0].length; j++){
                System.out.print(nums[i][j]+ "\t");
            }
			System.out.println("\n");
        }
    }
}
