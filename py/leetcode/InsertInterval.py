'''
Leetcode problem No 57 Insert Interval
Leetcode problem No 56 Merge Interval
Solution written by Xuqiang Fang on 5 July, 2018
'''
class Interval(object):
    def __init__(self, s=0, e=0):
        self.start = s
        self.end = e
class Solution(object):
    def insert(self, intervals, new):
        s, e = new.start, new.end
        l, r = [], []
        for i in intervals:
            if i.end < s:
                l.append(i)
            elif i.start > e:
                r.append(i)
            else:
                s = min(i.start, s)
                e = max(e, i.end)
        return l + [Interval(s,e)] + r
    
    def merge(self, intervals):
        if not len(intervals):
            return []
        intervals.sort(key=lambda x : x.start)
        ans = [intervals[0]]
        for i in range(1, len(intervals)):
            inter = intervals[i]
            if inter.start <= ans[-1].end:
                ans[-1].end = max(inter.end, ans[-1].end) 
            else:
                ans.append(inter)
        return ans
def main():
    s = Solution()
    h = Interval(1,2)
    i = Interval(3,5)
    j = Interval(6,7)
    k = Interval(8,10)
    l = Interval(12,16)
    m = Interval(4,9)
    n = Interval(1,2)
    o = Interval(1,2)
    intervals = [h, i, j, k, l, n, o]
    for i in intervals:
        print('[' + str(i.start) + ',' + str(i.end) + ']')
    intervals = s.merge(intervals)
    intervals = s.insert(intervals, m)
    for i in intervals:
        print('[' + str(i.start) + ',' + str(i.end) + ']')
main()
