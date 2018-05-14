'''
Leetcode problem No 220 Contains Duplicates III
Solution written by Xuqiang Fang on 14 May, 2018
'''

class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        if t < 0 : return False
        n = len(nums)
        d = {}
        width = t + 1
        for i in range(n):
            id = nums[i] / width
            if id in d:
                return True

