//Leetcode problem 74 Search a 2D Matrix
//Leetcode problem 240 Search a 2D Matrix II
//Solution written by Xuqiang Fang on 12 March 2018
/*
Write an efficient algorithm that searches for a value in an m x n matrix.
This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/
//solution accepted
class Solution{
    //No 74
	public boolean searchMatrix_(int[][] matrix, int target) {
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
    
    //No 240
    public boolean searchMatrix(int[][] matrix, int target){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return false;
        //first method, perform binary search on each row, assume less row than column
        int m = matrix.length;
        int n = matrix[0].length;
        if(m <= n){
            for(int[] row : matrix){
                if(binarySearch(row, target))
                    return true;
            }
        }
        else{
            for(int j=0; j<n; ++j){
                if(binarySearch(matrix, j, target)) 
                    return true;
            }
        }

        return false;
    }

    private boolean binarySearch(int[][] matrix, int col, int target){
        int l = 0;
        int h = matrix.length-1;
        while(l <= h){
            int m = l + (h - l) / 2;
            if(matrix[m][col] == target)
                return true;
            else if(matrix[m][col] < target){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return false;
    }

    private boolean binarySearch(int[] nums, int target){
        int l = 0; 
        int h = nums.length-1;
        while(l <= h){
            int m = l + (h - l) / 2;
            if(nums[m] == target)
                return true;
            else if(nums[m] < target){
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return false;
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
