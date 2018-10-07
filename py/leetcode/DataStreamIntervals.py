'''
Leetcode problem No 352 Data Stream as Disjoint Intervals
Solution written by Xuqiang Fang on 12 July, 2018
'''
from bisect import bisect_left

class Interval:
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e

class SummaryRanges:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.__intervals__ = []
        
    def binSearch(self, intervals, val):
        '''
        :type intervals: [Interval]
        :type val: int
        :rtype: int
        '''
        l = 0; r = len(intervals)-1
        while l <= r:
            m = (l+r) // 2
            if intervals[m].start > val: ## find the upper bound where val should be before this bound
                r = m-1
            else:
                l = m+1
        return l
        
    def addNum(self, val):
        """
        :type val: int
        :rtype: void
        """
        i = self.binSearch(self.__intervals__, val)
        s = val; e = val
        if i!= 0 and self.__intervals__[i-1].end + 1 >= val:
            i -= 1
        while i!= len(self.__intervals__) and e+1 >= self.__intervals__[i].start:
            s = min(s, self.__intervals__[i].start)
            e = max(e, self.__intervals__[i].end)
            self.__intervals__.remove(self.__intervals__[i])
        self.__intervals__.insert(i, Interval(s,e))
        

    def getIntervals(self):
        """
        :rtype: List[Interval]
        """
        return self.__intervals__
        

def main():
    s = SummaryRanges()
    a = [1,3,7,2,6]
    for i in a:
        s.addNum(i)
        intervals = s.getIntervals()
        for j in intervals:
            print([j.start, j.end])
        print('********')

if __name__ == '__main__':
    main()
