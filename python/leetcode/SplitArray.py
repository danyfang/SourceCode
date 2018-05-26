'''
Leetcode problem No 410 Split Array Largest Sum
Solution written by Xuqiang Fang on  25 May, 2018
'''

class Solution(object):
    def splitArray(self, nums, m):
        """
        :type nums: List[int]
        :type m: int
        :rtype: int
        """
        b = 0
        s = 0
        for n in nums:
            b = max(b, n)
            s += n
        if m == 1:
            return s
        l = b
        r = s
        while l <= r:
            mid = (l + r) // 2
            if self.valid(mid, nums, m):
                r = mid - 1
            else:
                l = mid + 1
        return l

    def valid(self, t, nums, m):
        count = 1
        total = 0
        for n in nums:
            total += n
            if total > t:
                total = n
                count += 1
                if count > m:
                    return False
        return True

def main():
    s = Solution()
    nums = [7,2,5,10,8]
    print(s.splitArray(nums, 2))

main()
