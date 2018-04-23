//Leetcode problem 413 Arithmetic Slices
//Solution written by Xuqiang Fang on 23 April, 2018 
class Solution{
    public int numberOfArithmeticSlices(int[] A){
        if(A == null || A.length <= 2)
            return 0;
        int n = A.length;
        int num = 0;
        for(int i=1; i<n-1; ++i){
            if(A[i+1] - A[i] == A[i] - A[i-1]){
                int count = 0;
                while(i < n-1 && (A[i+1]-A[i] == A[i]-A[i-1])){
                    i++;
                    count++;
                }
                num += count*(count+1)/2;
            }
        }
        return num;
    }	
}

public class ArithmeticSlices{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,2,3,4,5};
        System.out.println(s.numberOfArithmeticSlices(A));
	}
}
