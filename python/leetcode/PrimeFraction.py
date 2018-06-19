'''
Leetcode problem No 786 K-th Smallest Prime Fraction
Solution written by Xuqiang Fang on 18 June, 2018
'''

class Solution(object):
    def kthSmallestPrimeFraction(self, A, K):
        """
        :type A: List[int]
        :type K: int
        :rtype: List[int]
        """
        ##binary search within virtual matrix
        n = len(A)
        l = 0; r = 1.0
        while l < r:
            m = (l + r) / 2
            m_f = 0.0; p = 0; q = 0; total = 0; j = 1
            for i in range(n-1):
                while j < n and A[i] > m*A[j]:
                    j += 1
                total += n - j
                if n == j:
                    break
                f = A[i] / A[j]
                if f > m_f:
                    p = i; q = j
                    m_f = f
            if total == K:
                return [A[p], A[q]]
            elif total > K:
                r = m
            else:
                l = m
        return []

def main():
    s = Solution()
    A = [1,2,3,5]
    print(s.kthSmallestPrimeFraction(A, 3))
main()
