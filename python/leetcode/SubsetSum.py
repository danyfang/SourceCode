'''
Leetcode problem No 416  Parition Equal Subset Sum
Solution written by Xuqiang Fang on 4 April 
'''

class Solution(object):
    def canPartition(self, nums):
        s = 0;
        for i in nums:
            s += i

        if((s & 1) == 1):
            return False
        s >>= 1
        dp = [0]*(s+1)
        dp[0] = 1
        for i in range(len(nums)):
            for j in range(s,nums[i]-1,-1):
                dp[j] += dp[j-nums[i]]

        if(dp[s] == 0):
            return False
        else:
            return True

nums = [1,5,11,5]
s = Solution()
print s.canPartition(nums)
print s.canPartition([1,2,3,5])

