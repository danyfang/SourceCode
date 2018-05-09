//Leetcode problem 766 Toeplitz Matrix
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=1; i<m; ++i){
            for(int j=1; j<n; ++j){
                if(matrix[i][j] != matrix[i-1][j-1])
                    return false;
            }
        }
        return true;
    }
}

public class ToeplitzMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] matrix = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
        System.out.println(s.isToeplitzMatrix(matrix));
	}
}
