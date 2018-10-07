'''
Leetcode problem No 862 Shortest Subarray with Sum at Least K
Solution written by Xuqiang Fang on 1 July, 2018
'''
import collections
class Solution(object):
    def shortestSubarray(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: int
        """
        n = len(A)
        B = [0] * (n + 1)
        for i in range(n):
            B[i+1] = B[i] + A[i]
        d = collections.deque()
        ans = n + 1
        for i in range(n+1):
            while d and B[i] - B[d[0]] >= K:
                ans = min(ans, i-d.popleft())
            while d and B[i] <= B[d[-1]]:
                d.pop()
            d.append(i)
        return ans if ans <= n else -1

def main():
    s = Solution()
    print(s.shortestSubarray([2,-1,2], 3))
    print(s.shortestSubarray([1,2], 4))
    print(s.shortestSubarray([1], 1))
    print(s.shortestSubarray([1,2,3,-5,4,-7,5,-8,6,-9,7,8,-4], 5)) #1
    print(s.shortestSubarray([1,2,-5,3,-5,4,-7,5,-8,6,-9,7,8,-4], 5))
main()
