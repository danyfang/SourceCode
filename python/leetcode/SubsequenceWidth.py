'''
Leetcode problem No 891 Sum of Subsequence Width
Solution written by Xuqiang Fang on 18 Aug, 2018
'''

class Solution(object):
    def sumSubseqWidths_(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        n = len(A)
        #print(n)
        A.sort()
        mod = 10**9 + 7; k = 2**30 % mod
        dp = [0] * n
        mul = [0] * n; mul[0] = 1
        for i in range(1,n):
            mul[i] = mul[i-1]*2
            mul[i] %= mod
        for i in range(1, n):
            if A[i] == A[i-1]:
                dp[i] = dp[i-1]*2
            else:
                for j in range(i):
                    dp[i] += (A[i]-A[j]) * mul[i-j-1]
            dp[i] %= mod
        return sum(dp)%mod

    def sumSubseqWidths(self, A):
        return sum(((1 << i) - (1 << len(A) - i - 1)) * a for i, a in enumerate(sorted(A))) % (10**9 + 7)

def main():
    s = Solution()
    A = [1,2,3,4,4,4]
    print(s.sumSubseqWidths(A))

if __name__ == '__main__':
    main()
