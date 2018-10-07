'''
Leetcode problem No 883 Generate Random Point in a Circle
Solution written by Xuqiang Fang on 28 July, 2018
'''
import random
import math
import matplotlib.pyplot as plt

class Solution(object):
    def __init__(self, radius, x_center, y_center):
        """
        :type radius: float
        :type x_center: float
        :type y_center: float
        """
        self.r = radius
        self.x_ = x_center
        self.y_ = y_center

    def randPoint(self):
        """
        :rtype: List[float]
        """
        l = math.sqrt(random.uniform(0,1))*self.r
        deg = random.uniform(0,1) * 360
        x = self.x_ + l * math.cos(deg)
        y = self.y_ + l * math.sin(deg)
        return [x, y]


def main():
    s = Solution(10, 5, -7.5)
    print(s.randPoint())
    print(s.randPoint())
    print(s.randPoint())
    print(s.randPoint())
    print(s.randPoint())
    ans_x = []
    ans_y = []
    for i in range(3000):
        a = s.randPoint()
        ans_x.append(a[0])
        ans_y.append(a[1])
    plt.scatter(ans_x, ans_y)
    plt.show()

if __name__ == "__main__":
    main()
