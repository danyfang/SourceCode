'''
Leetcode problem No 220 Contains Duplicates III
Solution written by Xuqiang Fang on 14 May, 2018
'''

class Solution(object):
    def containsNearbyAlmostDuplicate(self, nums, k, t):
        """
        :type nums: List[int]
        :type k: int
        :type t: int
        :rtype: bool
        """
        if t < 0 : return False
        n = len(nums)
        d = {}
        width = t + 1
        for i in range(n):
            m = nums[i] // width
            if m in d:
                return True
            if m-1 in d and abs(nums[i] - d[m-1]) < width:
                return True
            if m+1 in d and abs(nums[i] - d[m+1]) < width:
                return True
            d[m] = nums[i]
            if i>= k: del d[nums[i-k] // width]
        return False

def main():
    s = Solution()
    nums = [1,0,1,1]
    print(s.containsNearbyAlmostDuplicate(nums, 1, 0))
main()
