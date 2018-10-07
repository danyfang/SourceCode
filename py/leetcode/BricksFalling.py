'''
Leetcode problem No 803 Bricks Falling When Hit
Solution written by Xuqiang Fang on 15 Aug, 2018
'''

class Solution(object):
    def hitBricks(self, grid, hits):
        """
        :type grid: List[List[int]]
        :type hits: List[List[int]]
        :rtype: List[int]
        """
        m = len(grid); n = len(grid[0])

        def dfs(i, j):
            if not(0<=i<m and 0<=j<n) or grid[i][j] != 1:
                return 0
            ans = 1
            grid[i][j] = 2
            ans += sum(dfs(x,y) for x,y in [(i-1,j),(i+1,j),(i, j-1),(i, j+1)])
            return ans

        def connected(i, j):
            return i == 0 or any([0<=x<m and 0<=y<n and grid[x][y] == 2 for x, y in \
            [(i-1,j),(i+1,j),(i, j-1),(i, j+1)]])

        for i, j in hits:
            grid[i][j] -= 1

        ## all unfalling should be 2
        for i in range(n):
            dfs(0, i)

        ans = [0] * len(hits)
        for k in reversed(range(len(hits))):
            i, j = hits[k]
            grid[i][j] += 1
            if grid[i][j] == 1 and connected(i, j):
                ans[k] = dfs(i,j)-1
        return ans

def main():
    s = Solution()
    grid = [[1,0,0,0],[1,1,1,0]]
    hits = [[1,0]]
    print(s.hitBricks(grid, hits))

if __name__ == '__main__':
    main()
