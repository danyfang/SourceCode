'''
Leetcode problem No 837 New 21 Game
Solution written by Xuqiang Fang on 20 May, 2018 
'''

class Solution(object):
    def new21Game(self, N, K, W):
        """
        :type N: int
        :type K: int
        :type W: int
        :rtype: float
        """
        #won't draw at all
        if K == 0:
            return 0
        if K == 1:
            return N/W

        prob = 0.0
        for i in range(1,W):
            prob += 1/W * self.new21Game(N, K-i, W)

        return prob

def main():
    s = Solution()
    print(s.new21Game(10,1,10))
    print(s.new21Game(6,1,10))
    print(s.new21Game(21,17,10))

main()
