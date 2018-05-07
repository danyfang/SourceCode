//Leetcode problem 812 Largest Triangle Area
//Solution written by Xuqiang Fang on 6 May, 2018
class Solution{
    public double largestTriangleArea(int[][] points){
        double max = 0;
        for(int i=0; i<points.length; ++i){
            for(int j=i+1; j<points.length; ++j){
                for(int k=j+1; k<points.length; ++k){
                    int[] A = points[i];
                    int[] B = points[j];
                    int[] C = points[k];
                    double area = A[0]*B[1]+B[0]*C[1]+C[0]*A[1]-A[0]*C[1]-C[0]*B[1]-B[0]*A[1];
                    max = Math.max(max, 0.5*Math.abs(area));
                }
            }
        } 
        return max;
    }
}

public class LargestTriangle{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] points = {{0,0},{0,1},{1,0},{0,2},{2,0}};
        System.out.println(s.largestTriangleArea(points));
	}
}
