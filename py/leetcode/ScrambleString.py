'''
Leetcode problem No 87 Scramble String
Solution written by Xuqiang Fang on 14 June, 2018
'''

class Solution(object):
    def isScramble(self, s1, s2):
        """
        :type s1: str
        :type s2: str
        :rtype: bool
        """
        n, m = len(s1), len(s2)
        if n != m or sorted(s1) != sorted(s2):
            return False
        if n < 4 or s1 == s2:
            return True
        f = self.isScramble
        for i in range(1, n):
            if f(s1[:i], s2[:i]) and f(s1[i:], s2[i:]) or \
               f(s1[:i], s2[-i:]) and f(s1[i:], s2[:-i]):
                return True
        return False

def main():
    s = Solution()
    s1 = 'rgeat'
    s2 = 'great'
    s3 = 'rgtea'
    s4 = 'rtgea'
    print(s.isScramble(s1, s2))
    print(s.isScramble(s3, s2))
    print(s.isScramble(s3, s1))
    print(s.isScramble(s4, s1))
    print(s.isScramble(s4, s2))
    print(s.isScramble(s4, s3))
main()
