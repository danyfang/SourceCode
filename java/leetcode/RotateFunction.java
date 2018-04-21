//Leetcode problem 396 Rotate Function
//Solution written by Xuqiang Fang on 21 April, 2018 

class Solution{
    public int maxRotate(int[] A){
        //first method, straightforward calculation
        //exceeded time limit
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int temp = 0;
            for(int j=0; j<n; j++){
                temp += j * A[(n-i+j)%n];
            }
            max = Math.max(max, temp);
        }

        return max;
    }	
    //key point B_{k}(i) = B_{k-1}(i-1)
    //F_k = F_{k-1} + sum + (n-1) * B_{k-1}(n-1)
    public int maxRotateFunction(int[] A){
        if(A == null || A.length == 0)
            return 0;
        int n = A.length;
        int sum = 0;
        int f0 = 0;
        for(int i=0; i<n; ++i){
            f0 += A[i] * i; 
            sum += A[i];
        }
        int max = f0;
        System.out.println(f0);
        for(int i=1; i<n; ++i){
            int temp = f0 + sum - n * A[n-i];
            System.out.println(temp);
            max = Math.max(max, temp);
            f0 = temp;
        }
        
        return max;
    }
}

public class RotateFunction{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {4,3,2,6};
        System.out.println(s.maxRotateFunction(A));
	}
}
