//Leetcode problem 813 Largest Sum of Averages
//Solution written by Xuqiang Fang on 1 May, 2018 

class Solution{
    public double largestSumOfAverages(int[] A, int k){
        //define dp[m][i] as the largest averge sum for subarray[0,i] into m groups 
        int n = A.length;
        double[][] dp = new double[k][n];
        dp[0][0] = A[0];//
        for(int i=1; i<k; ++i){
            dp[i][i] = dp[i-1][i-1] + A[i]; 
        }
        for(int i=1; i<n; ++i){
            dp[0][i] = (i * dp[0][i-1] + A[i])/(i+1);
        }
        for(int i=1; i<k; ++i){
            for(int j=i+1; j<n; ++j){
                double max = 0;
                double sum = 0;
                for(int x=i; x<=j; ++x){
                    sum += A[x];
                }
                for(int x=i; x<=j; ++x){
                    max = Math.max(dp[i-1][x-1]+sum/(j-x+1), max);
                    sum -= A[x];
                }
                //System.out.println(sum);
                dp[i][j] = max;
            }
        }

        return dp[k-1][n-1];
    }	

    //another version, faster
    public double largest(int[] A, int k){
        int n = A.length;
        double[][] dp = new double[k+1][n+1];
        double[] sums = new double[n+1];
        for(int i=1; i<=n; ++i){
            sums[i] = sums[i-1] + A[i-1];
            if(i <= k){
                dp[i][i] = sums[i];
            }
            dp[1][i] = sums[i]/i;
        }
        for(int i=2; i<=k; ++i){
            for(int j=i+1; j<=n; ++j){
                double max = 0;
                for(int x=i; x<=j; ++x){
                    max = Math.max(max, dp[i-1][x-1] + (sums[j]-sums[x-1])/(j-x+1));
                }
                dp[i][j] = max;
            } 
        }

        return dp[k][n];
    }
}

public class AverageSum{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {9,1,2,3,9};
        System.out.println(s.largestSumOfAverages(A,Integer.valueOf(args[0])));
        System.out.println(s.largest(A,Integer.valueOf(args[0])));
	}
}
