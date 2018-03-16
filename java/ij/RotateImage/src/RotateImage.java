//Leetcode problem 48 Rotate Image
//Solution written by Xuqiang Fang on 09 March 2018
class Solution{
    public void rotate(int[][] matrix){
        int n = matrix.length;
        int times = 3;
        for(int i=0; i<n/2; i++){
            for(int j=i; j<n; j++){
                int x = i;
                int y = j;
                int temp = matrix[x][y];
                while(times-- > 0){
                    System.out.format("%d, %d",x,y);
                    int original = matrix[y][n-1-x];
                    matrix[y][n-1-x] = temp;
                    int w = x;
                    x = y;
                    y = n-1-w;
                    temp = original;
                }
                System.out.format("%d, %d",x,y);
                matrix[i][j] = temp;
            }
        }
    }
}

public class RotateImage{
    public static void main(String[] args){
        Solution s = new Solution();
        int[][] matrix = {{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        s.rotate(matrix);

    }
    public static void print(int[][] nums){
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums[0].length; j++){
                System.out.println(nums[i][j]);
            }
        }
    }
}
