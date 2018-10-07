'''
Leetcode problem No 891 Super Egg Drop
Solution written by Xuqiang Fang on 12 Aug, 2018
'''

class Solution(object):
    def superEggDrop(self, K, N):
        """
        :type K: int
        :type N: int
        :rtype: int
        """
        dp = [[0] * (K + 1) for i in range(N + 1)]
        for m in range(1, N + 1):
            for k in range(1, K + 1):
                dp[m][k] = dp[m - 1][k - 1] + dp[m - 1][k] + 1
            if dp[m][K] >= N: 
                return m

def main():
    s = Solution()
    print(s.superEggDrop(3, 6))
    print(s.superEggDrop(3, 14))

if __name__ == '__main__':
    main()
