//Leetcode problem 566 Reshape the Matrix
//Solution written by Xuqiang Fang on 27 April, 2018 

class Solution{
    public int[][] matrixReshape(int[][] nums, int r, int c){
        if(nums == null || nums.length == 0)
            return nums;
        int m = nums.length;
        int n = nums[0].length;
        if(m * n != r * c)
            return nums;

        int[][] result = new int[r][c];
        for(int i=0; i<r; ++i){
            for(int j=0; j<c; ++j){
                int k = (i * c + j) / n;
                int l = i * c + j - k * n;
                result[i][j] = nums[k][l];
            }
        }
        return result;
    }	
}

public class ReshapeMatrix{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] nums = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] result = s.matrixReshape(nums, 2,8);
        for(int[] i : result){
            for(int j : i){
                System.out.print(j + "\t");
            }
            System.out.println("\n");
        }
	}
}
