# given an array are there elements a, b, c such that a + b + c = 0
# find all unique triplets
# The idea is always similar, fix the first and then use two pointer for the mid and last
# we only need to be careful with the duplicate
import collections
class Solution:
    def threeSum(self, nums):
        if len(nums) < 3:
            return []
        nums, result, i = sorted(nums), [], 0
        while i < len(nums)-2:
            if nums[i] > 0:
                break
            j = i+1; k = len(nums)-1
            while j < k:
                s = nums[i] + nums[j] + nums[k]
                if s == 0:
                    result.append([nums[i], nums[j], nums[k]])
                if s <= 0:
                    j += 1
                    while nums[j] == nums[j-1] and  j < k:
                        j += 1
                if s >=0:
                    k -= 1
                    while nums[k] == nums[k+1] and j < k:
                        k -= 1
            i += 1
            while nums[i] == nums[i-1] and i < len(nums)-2:
                i += 1
        return result

    def fourSum(self, n):
        if len(n) < 4:
            return []
        n, ans, i = sorted(n), [], 0
        while i < len(n)-3:
            if n[i] > 0:
                break
            j = i + 1
            while j < len(n)-2:
                if n[j] + n[i] > 0:
                    break
                k = j + 1; l = len(n)-1
                while k < l:
                    s = n[i] + n[j] + n[k] + n[l]
                    if s == 0:
                        ans.append([n[i], n[j], n[k], n[l]])
                    if s <= 0:
                        k += 1
                        while k < l and n[k] == n[k-1]:
                            k += 1
                    if s >= 0:
                        l -= 1
                        while k < l and n[l] == n[l+1]:
                            l -= 1
                j += 1
                while n[j] == n[j-1] and j < len(n)-2:
                    j += 1
            i += 1
            while n[i] == n[i-1] and i < len(n)-3:
                i += 1
        return ans


def main():
    s = Solution()
    nums = [-1, 0, 1, 2, -1, -4]
    print(s.threeSum(nums))
    print(s.fourSum(nums))
    nums = [1,-1,-1,0]
    print(s.threeSum(nums)) #[[-1,0,1]]
main()
