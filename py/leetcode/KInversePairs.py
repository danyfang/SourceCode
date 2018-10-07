'''
Leetcode problem No 629 K Inverse Pairs Array
Solution written by Xuqiang Fang on 8 July, 2018
'''

class Solution(object):
    def kInversePairs(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: int
        """
        M = 1000000007
        dp = [[0]*(k+1) for _ in range(2)]
        dp[0][0] = 1
        for i in range(1, n+1):
            dp[i%2] = [0]*(k+1)
            dp[i%2][0] = 1
            for j in range(1, k+1):
                dp[i%2][j] = (dp[i%2][j-1] + dp[(i-1)%2][j]) % M
                if j-i >= 0:
                    dp[i%2][j] = (dp[i%2][j] - dp[(i-1)%2][j-i]) % M
        return dp[n%2][k]

def main():
    s = Solution()
    print(s.kInversePairs(90, 1000))
main()
