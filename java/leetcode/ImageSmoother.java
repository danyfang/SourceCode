//Leetcode problem 661 Image Smoother
//Solution written by Xuqiang Fang on 2 May, 2018 

class Solution{
    public int[][] imageSmoother(int[][] M){
        int m = M.length;
        int n = M[0].length;
        int[][] ret = new int[m][n];
        for(int i=0; i<m; ++i){
            for(int j=0; j<n; ++j){
                int sum = M[i][j];
                int count = 1;
                if(i-1>=0){
                    sum += M[i-1][j];
                    count++;
                    if(j-1>=0){
                        sum += M[i-1][j-1];
                        count++;
                    }
                    if(j+1<n){
                        sum += M[i-1][j+1];
                        count++;
                    }
                }
                if(i+1<m){
                    sum += M[i+1][j];
                    count++;
                    if(j-1>=0){
                        sum += M[i+1][j-1];
                        count++;
                    }
                    if(j+1<n){
                        sum += M[i+1][j+1];
                        count++;
                    }
                }
                if(j-1>=0){
                    sum += M[i][j-1];
                    count++;
                }
                if(j+1<n){
                    sum += M[i][j+1];
                    count++;
                }

                ret[i][j] = sum/count;
            }
        }

        return ret;
    }	
}

public class ImageSmoother{
	public static void main(String[] args){
		Solution s = new Solution();
        int[][] M = {{1,2,3},{4,5,6},{7,8,9}};
        for(int[] n : M){
            for(int i : n){
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }

        int[][] N = s.imageSmoother(M);
        System.out.println("********************");
        for(int[] n : N){
            for(int i : n){
                System.out.print(i + "\t");
            }
            System.out.println("\n");
        }
	}
}
