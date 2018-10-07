'''
Leetcode problem No 403 Frog Jump 
Solution written by Xuqiang Fang on 22 June, 2018
'''

class Solution(object):
    def canCross(self, stones):
        """
        :type stones: List[int]
        :rtype: bool
        """
        if stones[1] != 1:
            return False
        n = len(stones)
        dp = {}
        for i in stones:
            dp[i] = set()
        dp[1].add(1)
        moves = (-1,0,1)
        for i in range(1,n-1):
            s = dp[stones[i]]
            if len(s) == 0:
                break
            for j in s:
                for x in moves:
                    key = stones[i] + j + x
                    if x+j > 0 and key in dp:
                        dp[key].add(x+j)

        return len(dp[stones[n-1]]) > 0
def main():
    s = Solution()
    stones = [0,1,3,5,6,8,12,17]
    print(s.canCross(stones))
    stones = [0,1,2,3,4,8,9,11]
    print(s.canCross(stones))
main()
