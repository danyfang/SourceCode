'''
Leetcode problem No 678 Valid Parenthesis String 
Solution written by Xuqiang Fang on 30 May, 2018
'''

class Solution(object):
    def checkValidString(self, s):
        """
        :type s: str
        :rtype: bool
        """
        l = 0
        h = 0
        for i in s:
            if i == '(':
                l += 1
                h += 1
            elif i == ')':
                if l > 0:
                    l -= 1
                h -= 1
            else:
                if l > 0:
                    l -= 1
                h += 1
            if h < 0:
                return False
        return l == 0

def main():
    s = Solution()
    print(s.checkValidString("(((**(((()))*((******"))
    print(s.checkValidString("(((**(()))*((**"))

main()
