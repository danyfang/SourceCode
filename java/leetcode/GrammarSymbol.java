//Leetcode problem 779 K-th Symbol in Grammar
//Solution written by Xuqiang Fang on 15 May,2018
class Solution{
    public int kthGrammar(int N, int K){
        if(K == 1){
            return 0;
        }
        else if(K == 2){
            return 1;
        }
        else if( K % 2 == 0){
            return Math.abs(1 - kthGrammar(N-1, K/2));
        }
        return kthGrammar(N-1, (K+1)/2);
    }
}

public class GrammarSymbol{
	public static void main(String[] args){
		Solution s = new Solution();
        System.out.println(s.kthGrammar(30, Integer.valueOf(args[0])));
	}
}
