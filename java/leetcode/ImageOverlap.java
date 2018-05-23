//Leetcode problem 835 Image Overlap
//Solution written by Xuqiang Fang on 21 May, 2018
class Solution{
    public int largestOverlap(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int maxOverlap = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int temp = overlap(A,B,i,j, m, n);
                maxOverlap = Math.max(maxOverlap, temp);
                temp = overlap(B,A,i,j, m, n);
                maxOverlap = Math.max(maxOverlap, temp);
            }
        }
        return maxOverlap;
    }

    private int overlap(int[][] A, int[][] B, int x, int y, int m, int n){
        int res = 0;
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                if(x+i<m && y+j<n){
                    res += A[i][j] * B[x+i][y+j];
                } 
            }
        } 
        return res;
    }
}

public class ImageOverlap{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] A = {{1,1,0},{0,1,0},{0,1,0}};
        int[][] B = {{0,0,0},{0,1,1},{0,0,1}};
        System.out.println(s.largestOverlap(A,B));
	}
}
