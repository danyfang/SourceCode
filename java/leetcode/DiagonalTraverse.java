//Leetcode problem 498 Diagonal Traverse
//Solution written by Xuqiang Fang on 16 May, 2018
class Solution{
    public int[] findDiagonalOrder(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[m*n];
        int index = 0;
        for(int sum = 0; sum <= m+n-2; ++sum){
            if(sum % 2 == 0){
                for(int i=sum-m<0?0:sum-m+1; i<=sum && i < n; ++i){
                    res[index++] = matrix[sum-i][i];
                }
            }
            else{
                for(int i=sum-n<0?0:sum-n+1; i<=sum && i < m; ++i){
                    res[index++] = matrix[i][sum-i];
                } 
            }
        }
        return res;
    }
}

public class DiagonalTraverse{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] res = s.findDiagonalOrder(matrix);
        for(int i : res){
            System.out.println(i);
        }
	}
}
