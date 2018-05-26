'''
Leetcode problem No 5 Longest Palindromic Substring
Solution written by Xuqiang Fang on 24 May, 2018
'''

class Solution(object):
    def longestPalindrome(self, s):
        """
        :type s: str
        :rtype: str
        """
        if len(s) == 0:
            return s
        n = len(s)
        dp = [0 for x in range(n)] 
        dp[0] = 1
        ans = s[0]
        for i in range(1,n):
            c = dp[i-1]
            if i-c-1>=0 and s[i-c-1] == s[i]:
                dp[i] = dp[i-1] + 2
            else:
                for j in range(i-c, i+1):
                    if self.isPalin(s[j:i+1]):
                        dp[i] = i-j+1
                        break
            if dp[i] > len(ans):
                ans = s[i-dp[i]+1:i+1]

        return ans
    
    def isPalin(self, s):
        l = 0; r = len(s)-1
        while l < r:
            if s[l] != s[r]:
                return False
            l += 1
            r -= 1
        return True

def main():
    s = Solution()
    s1 = 'babad'
    s2 = 'cbbd'
    s3 = 'a'
    print(s.longestPalindrome(s1))
    print(s.longestPalindrome(s2))
    print(s.longestPalindrome(s3))

main()
