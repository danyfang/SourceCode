'''
Leetcode problem No 871 Minimum Number of Refueling Stops
Solution written by Xuqiang Fang on 15 July, 2018
'''
import heapq
class Solution(object):
    def minRefuelStops(self, target, startFuel, stations):
        """
        :type target: int
        :type startFuel: int
        :type stations: List[List[int]]
        :rtype: int
        """
        ### use priority queue to keep a set of reachable stations, each time 
        ### we refuel at the optimal station
        hq = []
        curr = startFuel
        ans = 0
        for s in stations:
            while curr < s[0]:
                if not hq:
                    return -1
                if hq:
                    curr -= heapq.heappop(hq)
                    ans += 1
            heapq.heappush(hq, -s[1])
        while curr < target:
            if not hq:
                return -1
            if hq:
                curr -= heapq.heappop(hq)
                ans += 1
        return ans 

def main():
    s = Solution()
    target = 100; startFuel = 1; stations = [[10,100]]
    print(s.minRefuelStops(target, startFuel, stations))
    target = 1; startFuel = 1; stations = []
    print(s.minRefuelStops(target, startFuel, stations))
    target = 999; startFuel = 1000; stations = [[5,100],[997,100],[998,100]] 
    print(s.minRefuelStops(target, startFuel, stations))
    target = 1000; startFuel = 83
    stations =[[25,27],[36,187],[140,186],[378,6],[492,202],[517,89],[579,234],[673,86],[808,53],[954,49]]
    print(s.minRefuelStops(target, startFuel, stations))
    stations =[[25,27],[36,187],[140,186],[378,6],[489,202],[517,89],[579,234],[673,86],[808,53],[954,49]]
    print(s.minRefuelStops(target, startFuel, stations))
    target = 100; startFuel = 10; stations = [[10,60],[20,30],[30,30],[60,40]]
    print(s.minRefuelStops(target, startFuel, stations))


if __name__ == '__main__':
    main()
