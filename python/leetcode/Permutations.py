'''
Leetcode problem No 46 Permutations
Leetcode problem No 47 Permutations II
Solution written by Xuqiang Fang on 14 May, 2018 
'''

class Solution(object):
    def permute(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        res = []
        self.dfs(nums, res, [])
        return res

    def dfs(self, nums, res, temp):
        if len(temp) == len(nums):
            res.append(list(temp))
            #print(res)
        for num in nums:
            if not num in temp:
                temp.append(num)
                self.dfs(nums, res, temp)
                temp.pop(len(temp)-1)
    


    '''
    for the duplicate version here, the key idea is for all duplicate items, there is an internal
    order between all the duplicate items, that way we can avoid duplicate results
    '''
    def permuteUnique(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        nums = sorted(nums)
        used = [0] * len(nums)
        res = []
        self.helper(nums, used, res, [])
        return res

    def helper(self, nums, used, res, temp):
        if len(temp) == len(nums):
            res.append(list(temp))
            return
        for i in range(len(nums)):
            if used[i]: continue
            if i > 0 and nums[i-1] == nums[i] and (not used[i-1]): continue
            used[i] = 1
            temp.append(nums[i])
            self.helper(nums, used, res, temp)
            used[i] = 0
            temp.pop(len(temp)-1)


s = Solution()
x = [1,2,5]
print(s.permute(x))
y = [1,3,3,4,4]
z = [3,3,0,3]
print(s.permuteUnique(z))
