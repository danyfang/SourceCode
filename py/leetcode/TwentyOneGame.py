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
        if K == 0 or N >= K + W:
            return 1.0
        p = [0.0 for i in range(N+1)]
        p[0] = 1.0
        s = 1.0
        ans = 0.0
        for i in range(1,N+1):
            p[i] = s / W
            if i < K:
                s += p[i]
            else:
                ans += p[i]
            if i >= W:
                s -= p[i-W]
        return ans

def main():
    s = Solution()
    print(s.new21Game(10,1,10))
    print(s.new21Game(6,1,10))
    print(s.new21Game(21,17,10))

main()
