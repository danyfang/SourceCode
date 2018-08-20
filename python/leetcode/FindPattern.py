'''
Leetcode problem No 890 Find and Replace Pattern
Solution written by Xuqiang Fang on 19 Aug, 2018
'''

class Solution(object):
    def findAndReplacePattern(self, words, pattern):
        """
        :type words: List[str]
        :type pattern: str
        :rtype: List[str]
        """
        ans = []
        p = self.pat(pattern)
        for w in words:
            if self.pat(w) == p:
                ans.append(w)
        return ans

    def pat(self, s):
        i = 0; d = {}; ans = [0 for _ in range(len(s))]
        for j in range(len(s)):
            if s[j] not in d:
                i += 1
                d[s[j]] = i
                ans[j] = i
            else:
                ans[j] = d[s[j]]
        return ans

def main():
    s = Solution()
    words = ["abc","deq","mee","aqq","dkd","ccc"]; pattern = "abb"
    print(s.findAndReplacePattern(words, pattern))

if __name__ == '__main__':
    main()
