'''
Leetcode problem No 765 Couples Holding Hands
Solution written by Xuqiang Fang on 20 June, 2018
'''

class Solution(object):
    def minSwapsCouples(self, row):
        """
        :type row: List[int]
        :rtype: int
        """
        n = len(row)
        v = set()
        q = []
        v.add(''.join(str(x) for x in row))
        return 0

def main():
    s = Solution()
    row = [3,2,0,1]
    print(s.minSwapsCouples(row))
main()
