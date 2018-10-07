'''
Leetcode problem No 64 Minimum Path Sum
Solution written by Xuqiang Fang on 20 May, 2018
'''

class Solution(object):
    def minPathSum(self, grid):
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        m = len(grid)
        n = len(grid[0])
        dp = [[0 for x in range(n)] for y in range(m)]

        dp[0][0] = grid[0][0] 
        for i in range(1,m):
            dp[i][0] = dp[i-1][0] + grid[i][0]

        for j in range(1,n):
            dp[0][j] = dp[0][j-1] + grid[0][j]

        for i in range(1,m):
            for j in range(1,n):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]

        return dp[m-1][n-1]
    
    def minPath(self, grid):
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        return self.recursion(grid, len(grid)-1, len(grid[0])-1)
        
    def recursion(self, grid, x, y):
        if x < 0 or y < 0:
            return 2**31
        elif x == 0 and y == 0:
            return grid[0][0]
        elif x == 0:
            return grid[0][y] + self.recursion(grid, x, y-1)
        elif y == 0:
            return grid[x][0] + self.recursion(grid, x-1, y)

        return grid[x][y] + min(self.recursion(grid, x-1, y), self.recursion(grid, x, y-1))
        

        

def main():    
    s = Solution()
    grid = [[1,3,1],[1,5,1],[4,2,1]]
    print('Use recursion, the result is: ')
    print(s.minPath(grid))
    print('Use dynamic programming, the result is: ')
    print(s.minPathSum(grid))

main()
