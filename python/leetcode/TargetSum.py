'''
Leetcode problem No 494 TargetSum
Solution written by Xuqiang Fang on 4 April 
'''

class Solution(object):
    def findTargetSumWays(self, nums, S):
        sum = 0;
        for i in nums:
            sum += i

        if(sum < S or (sum+S)%2 > 0):
            return 0
        else:
            return self.subsetSum(nums, (sum+S)>>1)

    def subsetSum(self, nums, s):
        dp = [0]*(s+1)
        dp[0] = 1
        for i in nums:
            j = s
            while(j >= nums[i]):
                dp[j] += dp[j-nums[i]]
                j -= 1

        return dp[s]
        '''
        :type nums: List[int]
        :type S: int
        :rtype: int
        '''
s = Solution()
nums = [1,1,1,1,1]
print s.findTargetSumWays(nums, 3)
