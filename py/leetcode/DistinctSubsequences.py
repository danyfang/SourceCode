'''
Leetcode problem No 115 Distinct Subsequences
Solution written by Xuqiang Fang on 5 June, 2018
'''

class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """
        n = len(t)
        m = len(s)
        dp = [[0 for col in range(m+1)] for row in range(n+1)]
        for i in range(m+1):
            dp[0][i] = 1
        for i in range(n):
            for j in range(m):
                if s[j] == t[i]:
                    dp[i+1][j+1] = dp[i][j] + dp[i+1][j]
                else:
                    dp[i+1][j+1] = dp[i+1][j]
        return dp[n][m]

def main():
    s = Solution()
    s1 = "rabbbit";
    t1 = "rabbit";
    s2 = "babgbag";
    t2 = "bag";
    s3 = "daacaedaceacabbaabdccdaaeaebacddadcaeaacadbceaecddecdeedcebcdacdaebccdeebcbdeaccabcecbeeaadbccbaeccbbdaeadecabbbedceaddcdeabbcdaeadcddedddcececbeeabcbecaeadddeddccbdbcdcbceabcacddbbcedebbcaccac";
    t3 = "ceadbaa";
    print(s.numDistinct(s1, t1))
    print(s.numDistinct(s2, t2))
    print(s.numDistinct(s3, t3))

main()
