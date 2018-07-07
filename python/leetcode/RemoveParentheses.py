'''
Leetcode problem No 301 Remove Invalid Parentheses
Solution written by Xuqiang Fang on 5 July, 2018
'''

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        l = 0; r = 0
        for c in s:
            if c == '(':
                l += 1
            if l == 0:
                if c == ')':
                    r += 1
            else:
                if c == ')':
                    l -= 1
        ans = []
        self.dfs(s, 0, l, r, ans)
        return ans

    def dfs(self, s, start, l, r, ans):
        if l == 0 and r == 0:
            if self.isValid(s):
                ans.append(s)
            return 
        for i in range(start, len(s)):
            if i != start and s[i] == s[i-1]:
                continue
            if s[i] == '(' or s[i] == ')':
                curr = s[:i] + s[i+1:]
                if r > 0:
                    self.dfs(curr, i, l, r-1, ans)
                elif l > 0:
                    self.dfs(curr, i, l-1, r, ans)
            
    def isValid(self, s):
        count = 0
        for c in s:
            if c == '(':
                count += 1
            if c == ')':
                count -= 1
            if count < 0:
                return False
        return count == 0

    def combination(self, l, c):#select c from l
        '''
        l is a list, we have to select c elements from l
        '''
        ans = set()
        self.dfs_(ans, l, c, [])
        return ans
    def dfs_(self, ans, l, c, t):
        if len(t) > c:
            return 
        if len(t) == c:
            ans.add(tuple(t))
            return
        for j in l:
            if j not in t:
                t.append(j)
                self.dfs(ans, l, c, t)
                t.remove(j)
                
def main():
    s = Solution()
    print(s.removeInvalidParentheses('()())()'))
    print(s.removeInvalidParentheses('(a)())()'))
    print(s.removeInvalidParentheses(')('))
    print(s.removeInvalidParentheses(')()()()((((()))()('))
    print(s.removeInvalidParentheses('((((()))()'))
    print(len(s.removeInvalidParentheses('((((()()(fdsfas90()))((((((())))))))))(fsdafs()))()()afdsafsfs)')))
    print(s.removeInvalidParentheses('((((()()(fdsfas90()))((((((())))))))))(fsdafs()))()()afdsafsfs)'))
main()
