'''
Leetcode problem No 153 Find Minimum in Rotated Sorted Array I
Leetcode problem No 154 Find Minimum in Rotated Sorted Array II
Solution written by Xuqiang Fang on 
'''

#### this solution serves both questions but the complexity changes
'''
the first question complexity will be O(logn) that is because
half the array is sorted and we will always know
the second question complexity in worst case is O(n) since we
may not know which half is sorted
'''
class Solution(object):
    def findMin(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        return self.helper(nums, 0, len(nums)-1)

    def helper(self, nums, l, r):
        if l + 1 >= r:
            return min(nums[l], nums[r])
        if nums[l] < nums[r]:
            return nums[l]
        mid = (l + r) // 2
        return min(self.helper(nums, l, mid-1), self.helper(nums, mid, r))

if __name__ == "__main__":
    print(Solution().findMin([3, 1, 1, 2, 2, 3]))
    print(Solution().findMin([2, 2, 2, 3, 3, 1]))
    print(Solution().findMin([2, 2, 2, 3, 1, 2]))
    print(Solution().findMin([2, 2, 2, 2, 2, 2]))

