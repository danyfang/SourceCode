'''
Leetcode problem No 300 Longest Increasing Subsequence
Solution written by Xuqiang Fang on 20 June, 2018
'''

class Solution(object):
    ########
    '''
    This is a classic problem and the following is a classic solution in O(nlogn)
    tails is an array storing the smallest tail of all increasing subsequences with length i+1 in tails[i].
    For example, say we have nums = [4,5,6,3], then all the available increasing subsequences are:

    len = 1   :      [4], [5], [6], [3]   => tails[0] = 3
    len = 2   :      [4, 5], [5, 6]       => tails[1] = 5
    len = 3   :      [4, 5, 6]            => tails[2] = 6
    We can easily prove that tails is a increasing array.
    Therefore it is possible to do a binary search in tails array to find the one needs update.

    Each time we only do one of the two:

    (1) if x is larger than all tails, append it, increase the size by 1
        When we traverse the nums array from left to right, the current biggest would always be at the end
    (2) if tails[i-1] < x <= tails[i], update tails[i]
        When situation 2 happens, we can replace tails[i] but still the final length won't change
    Doing so will maintain the tails invariant. The the final answer is just the size.

    '''
    #######
    def lengthOfLIS(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        tails = [0] * len(nums)
        ans = 0
        for x in nums:
            i, j = 0, ans
            while i < j:
                m = (i+j) >> 1
                if x > tails[m]:
                    i = m + 1
                else:
                    j = m
            tails[i] = x
            if i == ans:
                ans += 1
        return ans

def main():
    s = Solution()
    nums = [10,9,2,5,3,7,101,18]
    print(s.lengthOfLIS(nums))
main()
