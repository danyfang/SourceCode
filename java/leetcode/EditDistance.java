//Leetcode problem 72 Edit Distance
//Solution written by Xuqiang Fang on 12 April, 2018 

class Solution{
    int minDistance(String word1, String word2){
        if(word1 == null)
            return word2 == null ? 0 : word2.length();
        if(word2 == null)
            return word1.length();
        int l1 = word1.length();
        int l2 = word2.length();
        System.out.println("I'm here");
        return helper(word1, word2, l1, l2);
    }	

    public int helper(String word1, String word2, int l1, int l2){
        if(l1 == 0)
            return l2;
        if(l2 == 0)
            return l1;

        if(word1.charAt(l1-1) == word2.charAt(l2-1))
            return helper(word1, word2, l1-1, l2-1);
        else
            return Math.min(helper(word1, word2, l1-1, l2),
                    Math.min(helper(word1, word2, l1, l2-1), helper(word1, word2, l1-1, l2-1)))+1;
    }

    int minDistance_(String word1,String word2){
        if(word1 == null)
            return word2 == null ? 0 : word2.length();
        if(word2 == null)
            return word1.length();
        int l1 = word1.length();
        int l2 = word2.length();
        
        int dp[][] = new int[l1+1][l2+1];
        for(int i=0; i<=l1; i++){
            dp[i][0] = i;
        }
        for(int j=0; j<=l2; j++){
            dp[0][j] = j;
        }
        
        int c = 0;
        for(int i=1; i<=l1; i++){
            for(int j=1; j<=l2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) 
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]))+1;
            }
        }
        return dp[l1][l2];
    }
}

public class EditDistance{
	public static void main(String[] args){
		Solution s = new Solution();
        String word1 = "hellasfsdo";
        String word2 = "world";
        System.out.println(s.minDistance_(word1, word2));
	}
}
