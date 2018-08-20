'''
Leetcode problem No 664 Strange Printer
Solution written by Xuqiang Fang on 13 Aug, 2018
'''

class Solution(object):
    def strangePrinter_(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        dp = [[0] * (n+1) for _ in range(n+1)]
        for i in range(n):
            dp[i][i] = 1
        for l in range(1, n):
            for i in range(n-l):
                j = i+l
                dp[i][j] = dp[i][j-1]+1
                for k in range(i, j):
                    t = dp[i][k] + dp[k+1][j]
                    if s[k] == s[j]:
                        t -= 1
                    dp[i][j] = min(dp[i][j], t)

        for d in dp:
            print(d)
        return dp[0][n-1]

    def strangePrinter(self, s):
        """
        :type s: str
        :rtype: int
        """
        memo = {}
        def dp(i, j):
            if i > j : return 0
            if (i, j) not in memo:
                ans  = dp(i+1, j)+1
                for k in range(i+1, j+1):
                    if s[k] == s[i]:
                        ans = min(ans, dp(i,k-1)+dp(k+1,j))
                memo[i,j] = ans
            return memo[i,j]
        return dp(0, len(s)-1)

def main():
    s = Solution()
    print(s.strangePrinter('tgbtbg'))
    print(s.strangePrinter('aaabbb'))
    print(s.strangePrinter('leetcode'))
    print(s.strangePrinter("dvdamcpqesjzyzhgfpkgodvctchzukuv"))

if __name__ == '__main__':
    main()
