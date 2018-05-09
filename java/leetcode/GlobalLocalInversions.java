//Leetcode problem 775 Global and Local Inversions
//Solution written by Xuqiang Fang on 9 May, 2018
class Solution{
    public boolean isIdeal(int[] A){
        //O(n^2) solution, TLE
        for(int i=0; i<A.length; ++i){
            for(int j=i+2; j<A.length; ++j){
                if(A[i] > A[j])
                    return false;
            }
        }
        return true;
    }

    public boolean isIdealPermutation(int[] A){
        for(int i=0; i<A.length; ++i){
            if(Math.abs(i - A[i]) >= 2)
                return false;
        }
        return true;
    }
}

public class GlobalLocalInversions{
	public static void main(String[] args){
		Solution s = new Solution();
        int[] A = {1,0,2};
        int[] B = {1,2,0};
        System.out.println(s.isIdealPermutation(A));
        System.out.println(s.isIdealPermutation(B));
	}
}
