'''
Leetcode problem No 861 Score After Flipping Matrix
Solution written by Xuqiang Fang on 2 July, 2018
'''

class Solution(object):
    def matrixScore(self, A):
        """
        :type A: List[List[int]]
        :rtype: int
        """
        m = len(A); n = len(A[0])
        for i in range(m):
            if A[i][0] == 0:
                for j in range(n):
                    A[i][j] = 1 - A[i][j]
        for j in range(n):
            c = 0
            for i in range(m):
                if A[i][j]:
                    c += 1
            if c < (m+1) // 2:
                for x in range(m):
                    A[x][j] = 1 - A[x][j]
        s = 0
        for i in range(m):
            for j in range(n):
                if A[i][j]:
                    s += 2**(n-1-j)
        return s
                

def main():
    s = Solution()
    A = [[0,0,1,1],[1,0,1,0],[1,1,0,0]]
    print(s.matrixScore(A))
main()
