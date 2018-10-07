'''
Leetcode problem No 856 Score of Parentheses
Solution written by Xuqiang Fang on 24 June, 2018
'''

class Solution(object):
    def scoreOfParentheses(self, S):
        """
        :type S: str
        :rtype: int
        """
        p = 0; c = 0
        ans = []
        for i in range(len(S)):
            if S[i] == '(':
                c += 1
            else:
                c -= 1
            if c == 0:
                ans.append(S[p:i+1])
                p = i + 1
        return self.helper(ans)
    def helper(self, l):
        ans = 0
        for s in l:
            if s == '()':
                ans += 1
            else:
                ans += 2 * self.scoreOfParentheses(s[1:len(s)-1])
        return ans

def main():
    s = Solution()
    print(s.scoreOfParentheses('()'))
    print(s.scoreOfParentheses('()()'))
    print(s.scoreOfParentheses('(())'))
    print(s.scoreOfParentheses('(()(()))'))
main()
