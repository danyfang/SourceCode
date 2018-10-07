'''
Leetcode problem No 754 Reach a Number
Solution written by Xuqiang Fang on 14 June, 2018
'''

class Solution(object):
    def reachNumber(self, target):
        """
        :type target: int
        :rtype: int
        """
        target = abs(target)
        i = 1; s = 0
        while(s < target):
            s += i
            i += 1
        if s == target or (s-target)%2 == 0:
            return i-1
        elif i % 2 != 0:
            return i
        return i+1


def main():
    s = Solution()
    print(s.reachNumber(2))
    x = int(input())
    while(x):
        print(s.reachNumber(x))
        x = int(input())
main()
