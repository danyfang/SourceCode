class Solution(object):
    def canPartitionKSubsets(self, nums, k):
        totalSum = sum(nums)
        if k <= 0 or totalSum % k != 0 :
            return False
        visited = [0] * len(nums)
        return self.dfs(nums, visited, 0, k, 0, 0, totalSum/k)

    def dfs(self, nums, visited, index, k, tempSum, num, target):
        if k == 1: return True
        if tempSum == target and num > 0:
            return self.dfs(nums, visited, 0, k-1, 0, 0, target)
        for i in range(index, len(nums)):
            if visited[i] == 0:
                visited[i] = 1
                if self.dfs(nums, visited, i+1, k, tempSum+nums[i], num+1, target):
                    return True
                visited[i] = 0
        return False

s = Solution()
nums1 = [4,3,2,3,5,2,1,1,1,1,1,1,1,1,1]
nums2 = [2,2,2,2,3,4,5]#test 4
nums3 = [1,2,3,4,5,5,5,5,5,5,5,5,5,5,5,5]
nums4 = [3522,181,521,515,304,123,2512,312,922,407,146,1932,4037,2646,3871,269]#test 5
nums = [nums1, nums2, nums3, nums4]


for num in nums:
    while True:
        x = input()
        result = s.canPartitionKSubsets(num,int(x)) 
        print(result)
        if result:
            break


