'''
Leetcode problem No 719 Find K-th Smallest Pair Distance
Solution written by Xuqiang Fang on 19 June, 2018
'''

class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        print(nums)
        n = len(nums)
        l = 0; r = nums[n-1]
        while(l <= r):
            m = (l + r) // 2
            count = 0; dis = 0; j = n-1
            for i in range(n-2, -1, -1):
                while j > i and nums[j]-nums[i] > m:
                    j -= 1
                count += j-i
                if nums[j]-nums[i] > dis:
                    dis = nums[j] - nums[i]
            if count == k or l == r:
                return dis
            elif count > k:
                r = m
            else:
                l = m+1
        return 0
        

def main():
    s = Solution()
    nums = [1,3,1]
    num = [9,10,7,10,6,1,5,4,9,8]
    print(s.smallestDistancePair(nums, 1))
    print(s.smallestDistancePair(nums, 2))
    print(s.smallestDistancePair(nums, 3))
    print(s.smallestDistancePair(num, 32))
main()
