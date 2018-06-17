'''
Leetcode problem No 780 Reaching Points
Solution written by Xuqiang Fang on 17 June, 2018
'''

class Solution(object):
    def reachingPoints(self, sx, sy, tx, ty):
        """
        :type sx: int
        :type sy: int
        :type tx: int
        :type ty: int
        :rtype: bool
        """
        while tx >= sx and ty >= sy:
            if tx > ty:
                if ty == sy:
                    return (tx-sx)%ty == 0
                tx %= ty
            else:
                if tx == sx:
                    return (ty-sy)%tx == 0
                ty %= tx
        return False


def main():
    s = Solution()
    print(s.reachingPoints(1,1,3,5))
    print(s.reachingPoints(1,1,1,1))
    print(s.reachingPoints(1,1,2,2))
    print(s.reachingPoints(1,1,19999,1))
    print(s.reachingPoints(1,2,1999999,2))
main()
