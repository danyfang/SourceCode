'''
Leetcode problem No 162 Find Peak Element
Solution written by Xuqiang Fang on 14 May, 2018
'''

class Solution(object):
    def findPeakElement(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        '''
        the idea is simple, find maximum using bianry search
        '''
        l = 0;
        n = len(nums)
        r = n - 1
        while(l < r):
            m1 = (l + r) // 2
            m2 = m1 + 1
            if nums[m1] < nums[m2]:
                l = m2
            else:
                r = m1

        return l

