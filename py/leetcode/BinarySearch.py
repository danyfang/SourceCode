'''
Leetcode problem No 704 Binary Search 
Solution written by Xuqiang Fang on 12 July, 2018
'''

class Solution(object):
    def search(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        if not nums:
            return -1
        l = 0; r = len(nums)
        while l < r:
            m = (l + r) // 2
            if nums[m] == target:
                return m
            if nums[m] < target:
                l = m+1
            else:
                r = m
        return -1
                

def main():
    s = Solution()
    nums = [-1,0,3,5,9,12]
    print(s.search(nums, 9))
    print(s.search(nums, 2))

if __name__ == '__main__':
    main()
