'''
Leetcode problem No 576 Out of Boundary Paths
Solution written by Xuqiang Fang on 16 June, 2018
'''

class Solution(object):
    def findPaths(self, m, n, N, i, j):
        """
        :type m: int
        :type n: int
        :type N: int
        :type i: int
        :type j: int
        :rtype: int
        """
        mod = 1000000007;
        dp = [[[0 for z in range(n)] for y in range(m)] for x in range(N+1)]
        print(dp)
        di = (1,0,-1,0,1);
        for s in range(1,N+1):
            for x in range(m):
                for y in range(n):
                    for d in range(4):
                        tx = x + di[d]
                        ty = y + di[d+1]
                        if tx < 0 or tx >= m or ty < 0 or ty >= n:
                            dp[s][x][y] += 1
                        else:
                            dp[s][x][y] += dp[s-1][tx][ty]
                            dp[s][x][y] %= mod
        return dp[N][i][j]

def main():
    s = Solution()
    print(s.findPaths(2,2,2,0,0))
    print(s.findPaths(1,3,3,0,1))
main()
