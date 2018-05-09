//Leetcode problem 795 Number of Subarrays with Bounded Maximum
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int[] B = new int[A.length+1];
        for(int i=0; i<A.length; i++){
            if(A[i] > R){
                B[i] = -1;
            }
            else if(A[i] >= L){
                B[i] = 1;
            }
        }
        B[A.length] = -1;

        int sum = 0;
        int prev = 0;
        for(int i=0; i<B.length; ++i){
            if(B[i] == -1){
                int count = 0;
                for(int j=i; j>=prev; --j){
                    if(B[j] == 1){
                        count = i - j;
                    } 
                    if(count > 0){
                        sum += count;
                    }
                }
                prev = i + 1;
            }
        }

        return sum;
    }
}

public class SubarrayBounded{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {73,55,36,5,55,14,9,7,72,52};
        System.out.println(s.numSubarrayBoundedMax(A, 32, 69));
	}
}
