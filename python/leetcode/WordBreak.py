'''
Leetcode problem No 139 Word Break
Solution written by Xuqiang Fang on 23 May, 2018
'''

class Solution(object):
    def wordBreak_(self, s, wordDict):
        """
        :type s: str
        :type wordDict: List[str]
        :rtype: bool
        """
        d = set(wordDict)
        l = len(s)
        dp = [0 for x in range(l+1)]
        for i in range(1,l+1):
            if (not dp[i]) and s[0:i] in d:
                dp[i] = 1
            if dp[i]:
                if i == l:
                    return True
                for j in range(i+1, l+1):
                    if (not dp[j]) and s[i:j] in d:
                        dp[j] = 1
                    if dp[j] and j == l:
                        return True
        return False


    def wordBreak(self, s, wordDict):
        d = set(wordDict)
        l = len(s)
        s = " " + s
        dp = [0 for x in range(l+1)]
        dp[0] = 1

        for i in range(1,l+1):
            for j in range(i):
                if dp[j] == 1:
                    print(s[j+1:i+1])
                    if s[j+1:i+1] in d:
                        dp[i] = 1
                        break
        print(dp)
        return (bool)(dp[l])
    
    def wordBreak_(self, s, wordDict):
        d = set(wordDict)
        m = {}
        return self.helper(s, d, m)

    def helper(self, s, d, m):
        if s in m:
            return m[s]
        a = []
        if s in d:
            a.append(s)
        for i in range(1, len(s)):
            if s[i:] in d:
                a.extend(self.append(self.helper(s[:i], d, m), s[i:]))
        m[s] = a
        return a

    def append(self, l, w):
        a = []
        for s in l:
            a.append(s + " " + w)
        return a
            

def main():
    s = Solution()
    S = 'applepenapple'
    w = ['apple', 'pen']
    print(s.wordBreak_(S, w))

main()
