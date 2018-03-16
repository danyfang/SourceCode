//Leetcode problem 74 Search a 2D Matrix
//Solution written by Xuqiang Fang on 12 March 2018
/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/
//solution accepted
class Solution{
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix.length == 0 || matrix[0].length == 0)
			return false;
       	int row = matrix.length;
		int col = matrix[0].length;
		if(target < matrix[0][0] || target > matrix[row-1][col-1])
			return false;

		int i = getRow(matrix, target, 0, row);
		return getCol(matrix, target, i, 0, col-1);		
    }
	public boolean getCol(int[][] matrix, int target, int row, int low, int high){
		if(matrix[row][low] == target || matrix[row][high] == target)
			return true;
		else if(low == high || low == high-1)
			return matrix[row][low] == target;	
		else if (matrix[row][low] < target && matrix[row][(low+high)/2] > target)
			return getCol(matrix, target, row, low, (high+low)/2);
		else 
			return getCol(matrix, target, row, (low+high)/2, high);
	}

	public int getRow(int[][] matrix, int target, int low, int high){
		if(low == high || low == high-1)
			return low;
		else if(matrix[low][0] <= target && matrix[(low+high)/2][0] > target)
			return getRow(matrix, target, low,  (low+high)/2);
		else
			return getRow(matrix, target, (low+high)/2, high);
	}
}

public class SearchMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,50},{51,57,78,98}};
		System.out.println(s.searchMatrix(matrix,35));
		System.out.println(s.getRow(matrix,50,0,4));
	}
}
