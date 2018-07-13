'''
Leetcode problem No 699 Falling Squares
Solution written by Xuqiang Fang on 12 July, 2018
'''
class Interval(object):
    def __init__(self, s, e, h):
        self.start = s
        self.end = e
        self.height = h

class Solution(object):
    def fallingSquares(self, positions):
        """
        :type positions: List[List[int]]
        :rtype: List[int]
        """
        ans = []
        curr = []
        highest = 0
        for i in positions:
            height = 0 
            for j in curr:
                if j.start >= i[0]+i[1] or j.end <= i[0]:
                    continue
                height = max(height, j.height)
            h = height + i[1]
            curr.append(Interval(i[0], i[0]+i[1], h))
            highest = max(highest, h)
            ans.append(highest)
        return ans

def main():
    s = Solution()
    positions = [[1, 2], [2, 3], [6, 1]]
    print(s.fallingSquares(positions))
if __name__ == '__main__':
    main()
