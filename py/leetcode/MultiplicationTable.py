'''
Leetcode problem No 668 Kth Smallest Number in Multiplication Table
Solution written by Xuqiang Fang on  19 June, 2018
'''

class Solution(object):
    def findKthNumber(self, m, n, k):
        """
        :type m: int
        :type n: int
        :type k: int
        :rtype: int
        """
        l = 0
        r = m * n + 1
        while l <= r:
            mid = (l + r) // 2
            total = 0; p =0; q = 0; max_k = 0
            j = n
            for i in range(1,m+1):
                while j >= 1 and i * j > mid:
                    j -= 1
                total += j
                if j == 0:
                    break
                if i * j > max_k:
                    p = i
                    q = j
                    max_k = i * j
            if total == k or l == r:
                return p * q
            elif total > k:
                r = mid
            else:
                l = mid+1
        return 0

def main():
    s = Solution()
    print(s.findKthNumber(2,3,6))
    print(s.findKthNumber(231,3312,6313))
    print(s.findKthNumber(232,3424,6422))
main()
