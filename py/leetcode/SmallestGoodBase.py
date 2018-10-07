'''
Leetcode problem No 483 Smallest Good Base
Solution written by Xuqiang Fang on 15 July, 2018
'''
import math
class Solution(object):
    def smallestGoodBase(self, n):
        """
        :type n: str
        :rtype: str
        """
        num = int(n)
        max_len = int(math.log(num,2))
        for l in range(max_len, 1, -1):
            b = int(num ** (l**-1))
            if (b**(l+1)-1) // (b-1) == num:
                return str(b)
        return str(num-1)

def main():
    s = Solution()
    print(s.smallestGoodBase("1000000000000000000"))
if __name__ == '__main__':
    main()
