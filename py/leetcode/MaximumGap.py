'''
Leetcode problem No 164 Maximum Gap
Solution written by Xuqiang Fang on 11 July, 2018 
'''

class Solution(object):
    def maximumGap(self, nums):
        n = len(nums)
        if n < 2:
            return 0
        h = max(nums); l = min(nums)
        if l == h:
            return 0
        ans = (h-l) // (n-1)
        width = ans
        width = max(width, 1)
        bucket = [[0, l, h] for _ in range((h-l)//width+1)]
        prev = n-1
        for num in nums:
            i = (num-l) // width
            prev = min(i, prev)
            bucket[i][0] += 1
            bucket[i][1] = max(bucket[i][1], num)
            bucket[i][2] = min(bucket[i][2], num)
        curr = prev + 1
        m = len(bucket)
        while curr < m:
            if bucket[curr][0] == 0:
                curr += 1
                continue
            ans = max(ans, bucket[curr][2]-bucket[prev][1])
            prev = curr
            curr += 1
        return ans

def main():
    s = Solution()
    nums = [1,2,3,4,5,6,6,7,8,9]
    print(s.maximumGap(nums))
    nums = [0,0,0,0,0,0,0,0]
    print(s.maximumGap(nums))
main()
