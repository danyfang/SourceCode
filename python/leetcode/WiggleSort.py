'''
Leetcode problem No 324 Wiggle Sort II
Solution written by Xuqiang Fang on 25 May, 2018
'''

class Solution(object):
    def wiggleSort(self, nums):
        """
        :type nums: List[int]
        :rtype: void Do not return anything, modify nums in-place instead.
        """
        c = list(nums)
        c.sort()
        index = 0
        if len(nums) % 2 == 0:
            i = len(nums) - 2
            while index < len(nums):
                nums[i] = c[index]
                index += 1
                i = i - 2
                if i < 0:
                    i = len(nums) - 1
        else:
            i = 0
            while index < len(nums):
                nums[i] = c[index]
                index += 1
                i = i + 2
                if i >= len(nums):
                    i = 1
def main():
    s = Solution()
    nums = [1, 5, 1, 1, 6, 4]
    vec = [4,5,5,5,5,6,6,6]
    s.wiggleSort(nums)
    s.wiggleSort(vec)
    print(nums)
    print(vec)

main()
    
