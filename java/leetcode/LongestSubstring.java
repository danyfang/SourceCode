//Leetcode problem 3 Longest Substring Without Repeating Characters
//Solution written by Xuqiang Fang on 24 May, 2018
class Solution{
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        int ans = 1;
        boolean updated = false;
        for(int i=1; i<dp.length; ++i){
            updated = false;
            for(int j=i-dp[i-1]; j<i; ++j){
                if(s.charAt(j) == s.charAt(i)){
                    dp[i] = i-j;
                    updated = true;
                    break;
                }
            }
            if(!updated){
                dp[i] = dp[i-1] + 1; 
            }
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}

public class LongestSubstring{
	public static void main(String[] args){
		Solution s = new Solution();
        String s1 = "cbabcba";
        String s2 = "bbbbb";
        String s3 = "pwwwkew";
        System.out.println(s.lengthOfLongestSubstring(s1));
        System.out.println(s.lengthOfLongestSubstring(s2));
        System.out.println(s.lengthOfLongestSubstring(s3));
	}
}
