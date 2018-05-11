'''
Leetcode problem No 81 Search in Rotated Sorted Array II
Solution written by Xuqiang Fang on 11 May, 2018
'''

class Solution(object):
    def search(self, nums, target):
        """
        :type nums : List[int]
        :type target: int
        :rtype: bool
        """
        if len(nums) == 0 : return False
        l = 0; h = len(nums) - 1
        while l < h:
            m = l + (h - l) / 2
            print('m = {}'.format(m))
            if nums[m] == target : return True
            if nums[l] < nums[m]:
                if nums[l] <= target and target < nums[m]:
                    h = m - 1
                else:
                    l = m + 1
            elif nums[m] < nums[h]:
                if nums[m] < target and target <= nums[h]:
                    l = m + 1
                else:
                    h = m - 1
            else:
                if nums[m] == nums[l]: 
                    l += 1
                if nums[h] == nums[m]:
                    h -= 1

        return True if nums[l] == target else False

s = Solution()
nums = [1,1,2,3,4,0,0,1,1]
print(s.search(nums, 8))
