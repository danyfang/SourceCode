'''
Leetcode problem No 354 Russian Doll Envelopes
Solution written by Xuqiang Fang on 19 June, 2018
'''

class Solution(object):
    #### this solution is TLE, mainly due to O(n^2) dp step
    #### So the optimization should work on the dp step
    #### which we can obviously boost with binary search
    #### How to solove longest increasing subsequence in NlogN
    def maxEnvelopes_(self, en):
        """
        :type envelopes: List[List[int]]
        :rtype: int
        """
        n = len(en)
        if n == 0:
            return 0
        en.sort()
        dp = [1 for i in range(n)]
        ans = 1
        for i in range(1, n):
            for j in range(0, i):
                if en[i][1] > en[j][1] and en[i][0] > en[j][0]:
                    dp[i] = max(dp[i], dp[j]+1)
            ans = max(ans, dp[i])
        return ans
   
    def maxEnvelopes__(self, en):
        def com(a, b):
            # a and b are both list
            if a[0] == b[0]:
                return b[1] - a[1]
            return a[0] - b[0]
        def lis(nums):
            tails = [0] * len(nums)
            size = 0
            for x in nums:
                i, j = 0, size
                while i != j:
                    m = (i+j) // 2
                    if tails[m] < x:
                        i = m + 1
                    else:
                        j = m
                tails[i] = x
                size = max(i+1, size)
            return size
        n = len(en)
        if n == 0:
            return 0
        en.sort(key=lambda x : (x[0], -x[1]))
        nums = [x[1] for x in en]
        return lis(nums) 

    ## optimized version
    def maxEnvelopes(self, en):
        n = len(en)
        if n == 0:
            return 0
        en.sort(key=lambda x: (x[0], -x[1]))
        tails = [0] * n
        ans = 0
        for x in en:
            i = 0; j = ans
            while i < j:
                m = (i+j) >> 1
                if x[1] > tails[m]:
                    i = m + 1
                else:
                    j = m
            tails[i] = x[1]
            if i == ans:
                ans += 1
        return ans
    
def main():
    s = Solution()
    envelopes = [[5,4],[6,4],[6,7],[2,3]]
    envelop = [[4,5],[4,6],[6,7],[2,3],[1,1]]
    print(s.maxEnvelopes(envelopes))
    print(s.maxEnvelopes(envelop))
main()
