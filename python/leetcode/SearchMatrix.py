'''
Leetcode problem No 240 Search a 2D Matrix II
Solution written by Xuqiang Fang on 11 May, 2018
'''
from sys import argv
class Solution(object):
    def searchMatrix(self, matrix, target):
        """
        :type matrix: List[List[int]]
        :type target: int
        :rtype: bool
        """
        if len(matrix) == 0 or len(matrix[0]) == 0 : return False

        m = len(matrix)
        n = len(matrix[0])
        i = 0 #row
        j = n-1 #column
        while i < m and j >= 0:
            if matrix[i][j] == target : return True
            elif matrix[i][j] < target: i += 1
            else : j -= 1

        return False

def main():
    s = Solution()
    target = int(argv[1])
    matrix = [
    [1,   4,  7, 11, 15],
    [2,   5,  8, 12, 19],
    [3,   6,  9, 16, 22],
    [10, 13, 14, 17, 24],
    [18, 21, 23, 26, 30]
    ]
    print(s.searchMatrix(matrix, target))

main()
