'''
Leetcode problem No 200 Number of Islands
Solution written by Xuqiang Fang on 19 May, 2018
'''

class Solution(object):
    def numIslands(self, grid):
        if len(grid) == 0 or len(grid[0]) == 0:
            return 0
        count = 0
        m = len(grid)
        n = len(grid[0])
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '1':
                    self.dfs(grid, i, j)
                    count += 1
        return count

    def dfs(self, grid, i, j):
        if i<0 or i>=len(grid) or j<0 or j>=len(grid[0]) or grid[i][j] != '1':
            return
        grid[i][j] = '0'
        self.dfs(grid, i-1, j)
        self.dfs(grid, i+1, j)
        self.dfs(grid, i, j-1)
        self.dfs(grid, i, j+1)

def main():
    s = Solution()
    grid = [['1','1','0','1','0'], ['1','1','0','0','1'],['0','0','1','0','0'],['0','0','0','1','1']]
    print(s.numIslands(grid))

main()
