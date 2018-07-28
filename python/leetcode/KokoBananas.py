'''
Leetcode problem No 875 Koko Eating Bananas
Solution written by Xuqiang Fang on 22 July, 2018
'''

class Solution(object):
    def minEatingSpeed(self, piles, H):
        """
        :type piles: List[int]
        :type H: int
        :rtype: int
        """
        r = max(piles)
        l = 1
        while l < r:
            m = (l + r) // 2
            ans = 0
            for p in piles:
                if p % m == 0:
                    ans += p // m
                else:
                    ans += p // m + 1
            if ans > H:
                l = m + 1
            else:
                r = m
        return l
def main():
    s = Solution()
    piles = [3,6,7,11]; H = 8
    print(s.minEatingSpeed(piles, H))
main()
