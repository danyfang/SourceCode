'''
Leetcode problem No 835 Image Overlap
Solution written by Xuqiang Fang on 21 May, 2018
'''

class Solution(object):
    def largestOverlap(self, A, B):
        """
        :type A: List[List[int]]
        :type B: List[List[int]]
        :rtype: int
        """
        m = len(A)
        n = len(A[0])
        area = 0
        for i in range(m):
            for j in range(n):
                area = max(area, self.overlap(A,B,m,n,i,j))
                area = max(area, self.overlap(B,A,m,n,i,j))
        return area
    def overlap(self, A, B, m, n, i, j):
        res = 0
        for x in range(m):
            for y in range(n):
                if x+i < m and y+j < n:
                    res += A[x][y]*B[x+i][y+j]
        return res

def main():
    s = Solution()
    A = [[1,1,0],[0,1,0],[0,1,0]]
    B = [[0,0,0],[0,1,1],[0,0,1]]
    print(s.largestOverlap(A,B))

main()
