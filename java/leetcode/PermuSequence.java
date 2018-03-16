//Leetcode problem 60 Permutation Sequence
//Solution written by Xuqiang Fang on 08 March 2018

import java.lang.Integer;
import java.lang.Math;

class Solution{
    public String getPermutation(int n, int k){
        int[] Fact = new int[9];
        Fact[0] = 1;
        for(int i=1; i<9; i++){
            Fact[i] = Fact[i-1] * (i+1);
        }
		if(k > Fact[n-1] || k < Fact[0])
			return null;
        int[] num = new int[n];
        for(int i=0; i<n; i++){
            num[i] = i+1;
        }
		/*
		int start = 0;
		while(k != 1){
			int fact = Fact[findPos(k,Fact)];
			int end = (k-1)/fact;
			changePos(start,end,num);
			start++;
			k = k % fact;
		}
		*/
        int start = 0;
        while(k != 1){
            int end = (k-1)/Fact[n-2-start] + start;
            changePos(start, end, num);
            k = k % Fact[n-2-start];
            start++;
            if(k == 0){
                sort(start, num);
                k = 1;
            }
        }
        int result = 0;
        for(int i=0; i<n; i++){
            result += num[i]*(int)(Math.pow(10,n-1-i));
        }

        return Integer.toString(result);
    }
    public void sort(int s, int[] num){
        for(int i=s; i<num.length; i++){
            for(int j=i+1; j<num.length; j++){
                if(num[i] < num[j]){
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }
    }
    /*
    public int findPos(int k, int[] F){
        int r = 0;
        if(k == F[F.length-1])
            r = F.length-1;
        for(int i=0; i<F.length-1; i++){
            if(k >= F[i] && k < F[i+1])
                r = i;
        }
        return r;
    */
    public void changePos(int s, int e, int[] num){
        if(s == e)
            return;
        if(s < e) {
            int temp = num[e];
            for (int i = e; i > s; i--) {
                num[i] = num[i - 1];
            }
            num[s] = temp;
        }
    }

}

public class PermuSequence{
    public static void main(String[] args){
        Solution s = new Solution();
        int[] num = {1,2,3,4};
        //System.out.println(s.findPos(4,num));
        s.changePos(0,0,num);
        for(int i=0; i<num.length; i++)
            System.out.println(num[i]);
        System.out.println(s.getPermutation(9,36280));
    }
}

