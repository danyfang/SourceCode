'''
Leetcode problem No 329 Longest Increasing Path in a Matrix
Solution written by Xuqiang Fang on 23 May, 2018
'''

class Solution(object):
    def longestIncreasingPath(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: int
        """
        if len(matrix) == 0 or len(matrix[0]) == 0:
            return 0
        m = len(matrix)
        n = len(matrix[0])
        dp = [[0 for x in range(n)] for y in range(m)]
        ans = 0
        for i in range(m):
            for j in range(n):
                dp[i][j] = self.dfs(matrix, m, n, i, j, dp)
                ans = max(ans, dp[i][j])
        return ans
    def dfs(self, matrix, m, n, i, j, dp):
        if i<0 or i>=m or j<0 or j>=n or matrix[i][j] == -2**32:
            return 0
        elif dp[i][j] > 0:
            return dp[i][j]
        s = 1
        c = matrix[i][j]
        matrix[i][j] = -2**32
        u,d,l,r = 0,0,0,0
        if i-1>=0 and matrix[i-1][j]>c:
            u = self.dfs(matrix, m, n, i-1, j, dp)
        if i+1<m and matrix[i+1][j]>c:
            d = self.dfs(matrix, m, n, i+1, j, dp)
        if j-1>=0 and matrix[i][j-1]>c:
            l = self.dfs(matrix, m, n, i, j-1, dp)
        if j+1<n and matrix[i][j+1]>c:
            r = self.dfs(matrix, m, n, i, j+1, dp)
        matrix[i][j] = c
        s += max(max(u,d), max(l,r))
        dp[i][j] = s
        return s
def main():
    s = Solution()
    matrix = [[9,9,4],[6,6,8],[2,1,1]] 
    nums = [[3,4,5],[3,2,6],[2,2,1]] 
    mat =  [[7,6,1,1],[2,7,6,0],[1,3,5,1],[6,6,3,2]]
    m = [[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]
    print(s.longestIncreasingPath(matrix))
    print(s.longestIncreasingPath(nums))
    print(s.longestIncreasingPath(mat))
    print(s.longestIncreasingPath(m))

main()
