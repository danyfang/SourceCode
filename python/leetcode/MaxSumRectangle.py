'''
Leetcode problem No 363 Max Sum of Rectangle No Larger Than K
Solution written by Xuqiang Fang on 12 July, 2018
'''
from bisect import bisect_left, insort
class Solution(object):
    def maxSumSubmatrix(self, matrix, k):
        """
        :type matrix: List[List[int]]
        :type k: int
        :rtype: int
        """
        if not matrix:
            return 0
        m = min(len(matrix), len(matrix[0]))
        n = max(len(matrix), len(matrix[0]))
        ans = float('-inf')
        for i in range(m):
            s = [0] * n
            for j in range(i, m):
                for l in range(n):
                    s[l] += matrix[j][l] if m == len(matrix) else  matrix[l][j]
                accum_set, accum = [0], 0
                for t in s:
                    accum += t
                    it = bisect_left(accum_set, accum-k)
                    print(accum_set)
                    print(it)
                    if it != len(accum_set):
                        ans = max(ans, accum-accum_set[it])
                    insort(accum_set, accum)
        return ans

def main():
    s = Solution()
    matrix = [[1,0,1],[0,-2,3]]
    print(s.maxSumSubmatrix(matrix, 2))

if __name__ == '__main__':
    main()
