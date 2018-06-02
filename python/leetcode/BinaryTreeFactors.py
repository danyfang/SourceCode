'''
Leetcode problem No 823 Binary Tree With Factors
Solution written by Xuqiang Fang on 1 June, 2018
'''

class Solution(object):
    def numFactoredBinaryTrees(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        mo = pow(10,9)+7
        n = len(A)
        A.sort()
        m = {A[0]:0}
        dp = [1 for i in range(n)]
        ans = 1
        for i in range(1,n):
            for j in range(i):
                if A[i]/A[j] in m:
                    dp[i] += dp[j] * dp[m[A[i]/A[j]]] 
                    dp[i] %= mo
            m[A[i]] = i
            ans += dp[i]
            ans %= mo
        return ans

def main():
    s = Solution()
    A = [2,3,4,5,8,10,12,16,20,24,28,30,32,36,40,50]
    print(s.numFactoredBinaryTrees(A))
main()
