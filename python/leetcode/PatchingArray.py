'''
Leetcode problem No 330 Patching Array
Solution written by Xuqiang Fang on 6 July, 2018
'''

class Solution(object):
    def minPatches(self, nums, n):
        """
        :type nums: List[int]
        :type n: int
        :rtype: int
        """
        cover = 0
        patch = []
        for i in nums:
            if i > (cover + 1):
                while i > cover + 1 and cover < n:
                    patch.append(cover+1)
                    cover = 2 * cover + 1
                cover += i
            else:
                cover += i
            if cover >= n:
                break
        while cover < n:
            patch.append(cover+1)
            cover = 2 * cover + 1
        return len(patch)

    def minPatches_(self, nums, n):
        #another solution inspired by user@StephanPorchman
        miss = 1; added = 0; i = 0
        m = len(nums)
        while miss <= n:
            if i < m and nums[i] <= miss:
                miss += nums[i]
                i += 1
            else:
                miss += miss
                added += 1
        return added

def main():
    s = Solution()
    print(s.minPatches([1,2,3,9], 10))
    print(s.minPatches([1,5,10], 20))
    print(s.minPatches([1,2,2], 5))
    print(s.minPatches([], 7))
    print(s.minPatches_([1,2,3,9], 10))
    print(s.minPatches_([1,5,10], 20))
    print(s.minPatches_([1,2,2], 5))
    print(s.minPatches_([], 7))
main()
