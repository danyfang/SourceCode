'''
Leetcode problem No 149 Max Points on a Line
Solution written by Xuqiang Fang on 4 July, 2018
'''
import collections
class Point(object):
    def __init__(self, a=0, b=0):
        self.x = a
        self.y = b

class Solution(object):
    def maxPoints(self, points):
        ans = 0
        for i, start in enumerate(points):
            count, same, curr = collections.defaultdict(int), 1, 0
            for j in range(i+1, len(points)):
                end = points[j]
                if start.x == end.x and start.y == end.y:
                    same += 1
                else:
                    s = self.slope(start, end)
                    count[s] += 1
                    curr = max(curr, count[s])
            ans = max(curr+same, ans)
        return ans
    def slope(self, p1, p2):
        dx = p1.x - p2.x
        dy = p1.y - p2.y
        if dy == 0:
            return (p1.y, 0)
        if dx == 0:
            return (p1.x, 0)
        d = self.gcd(dx, dy)
        return (dy // d, dx//d)
    def gcd(self, m, n):
        return m if n == 0 else self.gcd(n, m % n)

def main():
    s = Solution()
    a = Point(2,3)
    b = Point(1,1)
    c = Point(2,3)
    d = Point(2,3)
    e = Point(2,1)
    f = Point(4,7)
    g = Point(2,3)
    arr = [[0,0],[94911151,94911150],[94911152,94911151]]
    print(Solution().maxPoints([a,b,c,d,e,f,g]))
    print(Solution().maxPoints([Point(a[0], a[1]) for a in arr])) #expected 2
if __name__ == "__main__":
    main()
