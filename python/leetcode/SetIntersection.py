'''
Leetcode problem No 757 Set Intersection Size At Least Two
Solution written by Xuqiang Fang on 8 July, 2018
'''

class Solution:
    def intersectionSizeTwo(self, intervals):
        """
        :type intervals: List[List[int]]
        :rtype: int
        """
        intervals.sort(key = lambda x : x[1])
        #print(intervals)
        ans = [intervals[0][-1]-1, intervals[0][-1]]
        for it in intervals:
            left = ans[-2]
            right = ans[-1]
            if right < it[0]:
                ans.append(it[-1]-1)
                ans.append(it[-1])
            elif left < it[0]:
                if right == it[-1]:
                    ans.pop()
                    ans.append(right-1)
                    ans.append(right)
                else:
                    ans.append(it[-1])
        #print(ans)
        return len(ans)

def main():
    s = Solution()
    intervals = [[1, 2], [2, 3], [2, 4], [4, 5]]
    print(s.intersectionSizeTwo(intervals))
    intervals = [[2, 5], [3, 5], [1, 3], [1, 4]]
    print(s.intersectionSizeTwo(intervals))
main()
