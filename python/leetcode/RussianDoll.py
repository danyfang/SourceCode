'''
Leetcode problem No 354 Russian Doll Envelopes
Solution written by Xuqiang Fang on 19 June, 2018
'''

class Solution(object):
    #### this solution is TLE
    def maxEnvelopes(self, en):
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

def main():
    s = Solution()
    envelopes = [[5,4],[6,4],[6,7],[2,3]]
    envelop = [[4,5],[4,6],[6,7],[2,3],[1,1]]
    print(s.maxEnvelopes(envelopes))
    print(s.maxEnvelopes(envelop))
main()
