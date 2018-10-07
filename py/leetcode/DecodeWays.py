'''
Leetcode problem No 639 Decode Ways II
Solution written by Xuqiang Fang on 12 Aug, 2018
'''

class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)+1
        mod = 10 ** 9 + 7
        dp = [0] * n
        dp[0] = 1
        if s[0] == '0':
            return 0
        elif s[0] == '*':
            dp[1] = 9
        else:
            dp[1] = 1
        for i in range(2, n):
            if s[i-1] == '0':
                if s[i-2] == '*':
                    dp[i] += dp[i-2] * 2
                elif s[i-2] == '1' or s[i-2] == '2':
                    dp[i] += dp[i-2] 
                else:
                    dp[i] = 0
            elif s[i-1] == '*':
                dp[i] += dp[i-1] * 9
                if s[i-2] == '*':
                    dp[i] += dp[i-2] * 15
                elif s[i-2] == '1':
                    dp[i] += dp[i-2] * 9
                elif s[i-2] == '2':
                    dp[i] += dp[i-2] * 6
            else:
                dp[i] += dp[i-1]
                if s[i-2] == '*':
                    k = int(s[i-1])
                    if k >= 1 and k <= 6:
                        dp[i] += dp[i-2] * 2
                    else:
                        dp[i] += dp[i-2]
                else:
                    k = int(s[i-2:i])
                    if k >= 10 and k <= 26:
                        dp[i] += dp[i-2]
            dp[i] %= mod

        return dp[n-1]
    
    ##another smart solution
    def numDecodings_(self, s):
        """
        :type s: str
        :rtype: int
        """
        mod = 10 ** 9 + 7
        e0, e1, e2 = 1, 0, 0
        for ch in s:
            if ch == '*':
                f0 = (9 * e0 + 9 * e1 + 6 * e2) % mod
                f1 = e0
                f2 = e0
            else:
                f0 = ((ch > '0') * e0 + e1 + (ch < '7') * e2) % mod
                f1 = e0 if ch == '1' else 0
                f2 = e0 if ch == '2' else 0
            e0, e1, e2 = f0, f1, f2
            
        return f0

def main():
    s = Solution()
    print(s.numDecodings('1000*'))
    print(s.numDecodings('**'))
    print(s.numDecodings('******'))
    print(s.numDecodings_('******'))

if __name__ == '__main__':
    main()
