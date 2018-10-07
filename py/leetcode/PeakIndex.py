'''
Leetcode problem No 852 Peak Index in a Mountain Array
Solution written by Xuqiang Fang on 18 June, 2018
'''

class Solution(object):
    def peakIndexInMountainArray(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        n = len(A)
        ans = 0
        for i in range(1,n-1):
            if A[i] > A[i-1] and A[i] > A[i+1]:
                ans = i
                break
        return ans

def main():
    s = Solution()
    A = [0,2,1,0]
    print(s.peakIndexInMountainArray(A))
