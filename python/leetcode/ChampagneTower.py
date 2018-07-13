'''
Leetcode problem No 799 Champagne Tower
Solution written by Xuqiang Fang on 6 July, 2018
'''

class Solution(object):
    def champagneTower(self, poured, query_row, query_glass):
        """
        :type poured: int
        :type query_row: int
        :type query_glass: int
        :rtype: float
        define dp[i][j] as the total flow through glass (i, j)
        """
        R = 100
        dp = [[0 for col in range(R)] for row in range(R)]
        dp[0][0] = poured
        for i in range(R-1):
            for j in range(i+1):
                if dp[i][j] > 1: 
                    dp[i+1][j] += (dp[i][j]-1) / 2
                    dp[i+1][j+1] += (dp[i][j]-1) / 2
        #print(dp)
        return min(1.0, dp[query_row][query_glass])

def main():
    s = Solution()
    print(s.champagneTower(1,1,1))
    print(s.champagneTower(2,1,1))
    print(s.champagneTower(29,7,7))
main()
