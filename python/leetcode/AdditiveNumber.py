'''
Leetcode problem No 306 Additive Number
Solution written by Xuqiang Fang on 28 May, 2018
'''

class Solution(object):
    def isAdditiveNumber(self, num):
        """
        :type num: str
        :rtype: bool
        """
        if len(num) < 3:
            return False
        for i in range(1, len(num)//2+1):
            for j in range(1, (len(num)-i)//2+1):
                if self.valid(num[:i], num[i:i+j], num[i+j:]):
                    return True
        return False
    def valid(self, a, b, c):
        if len(a) > 1 and a[0] == '0':
            return False
        if len(b) > 1 and b[0] == '0':
            return False
        s = str(int(a) + int(b)) 
        if s == c:
            return True
        elif len(c) < len(s) or not c.startswith(s):
            return False
        return self.valid(b, s, c[len(s):])

def main():
    s = Solution()
    print(s.isAdditiveNumber('199100299'))
    print(s.isAdditiveNumber('02358'))
main()
