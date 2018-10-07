'''
Leetcode problem No 3 Longest Substring WithOut Repeating Characters
Solution written by Xuqiang Fang on 24 May, 2018
'''

class Solution(object):
    def lengthOfLongestSubstring(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        if n == 0:
            return 0
        dp = [0 for i in range(n)]
        #dp[i], the longest substring ending with character s[i]
        dp[0] = 1
        ans = 1
        for i in range(1, n):
            c = dp[i-1]
            for j in range(i-c,i):
                if s[j] == s[i]:
                    dp[i] = i-j
                    break
            else:
                dp[i] = dp[i-1] + 1
            ans = max(ans, dp[i])
        return ans

def main():
    s = Solution()
    print(s.lengthOfLongestSubstring('abcabcbb'))
    print(s.lengthOfLongestSubstring('bbbbb'))
    print(s.lengthOfLongestSubstring('pwwkew'))

main()
