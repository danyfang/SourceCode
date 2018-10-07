'''
Leetcode problem No 853 Car Fleet
Solution written by Xuqiang Fang on 18 June, 2018
'''

class Solution(object):
    def carFleet(self, target, position, speed):
        """
        :type target: int
        :type position: List[int]
        :type speed: List[int]
        :rtype: int
        """
        n = len(position)
        if n == 0:
            return 0
        car = [[target - position[x], speed[x]] for x in range(n)]
        car.sort(key = lambda l : l[0])
        ans = 0
        prev = 0
        for i in range(n):
            t = car[i][0] / car[i][1]
            if t > prev:
                prev = t
                ans += 1
        return ans

def main():
    s = Solution()
    position = [10,8,0,5,3]
    speed = [2,4,1,1,3]
    print(s.carFleet(12, position, speed))
main()
