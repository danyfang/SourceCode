'''
Leetcode problem No 40 Combination Sum II
Solution written by Xuqiang Fang on 31 July, 2018
'''

class Solution(object):
    '''
    return type list[list]
    '''
    def combinationSum2(self, nums, target):
        nums.sort()
        visited = set()
        ans = []
        self.dfs(nums, ans, visited, target, [], 0)
        return ans

    def dfs(self, nums, ans, v, s, t, i):
        t_sum = sum(t)
        if s < t_sum:
            return
        elif s == t_sum:
            if tuple(t) not in v:
                v.add(tuple(t))
                ans.append(list(t))
        else:
            for j in range(i, len(nums)):
                t.append(nums[j])
                self.dfs(nums, ans, v, s, t, j+1)
                t.pop()


def main():
    s = Solution()
    nums = [10, 1, 2, 7, 6, 1, 5]
    target = 8
    print(s.combinationSum2(nums, target))
    nums = [2,5,2,1,2]
    print(s.combinationSum2(nums, 5))

if __name__ == '__main__':
    main()

