'''
Leetcode problem No 457 Circular Array Loop
Solution written by Xuqiang Fang on 12 July, 2018
'''

class Solution(object):
    def circularArrayLoop(self, nums):
        """
        :type nums: List[int]
        :rtype: bool
        """
        N = len(nums)
        visited = set()
        for i in range(N):
            if i not in visited:
                visited.add(i)
                slow = i
                fast = i
                if nums[i] > 0:
                    while nums[slow] > 0 and nums[fast] > 0:
                        prev = slow #to detect loop of size one
                        slow = (slow + nums[slow]) % N
                        if slow == prev:
                            break
                        fast = (fast + nums[fast]) % N
                        prev = fast
                        fast = (fast + nums[fast]) % N
                        if prev == fast:
                            break
                        if nums[slow] > 0 and nums[fast] > 0:
                            visited.add(slow)
                            visited.add(fast)
                            if  fast == slow:
                                return True
                        
                else:
                    while nums[slow] < 0 and nums[fast] < 0:
                        prev = slow
                        slow = (slow + nums[slow]) % N
                        if slow == prev:
                            break
                        fast = (fast + nums[fast]) % N
                        prev = fast
                        fast = (fast + nums[fast]) % N
                        if fast == prev:
                            break
                        if nums[slow] < 0 and nums[fast] < 0:
                            visited.add(slow)
                            visited.add(fast)
                            if fast == slow:
                                print('here')
                                print(slow, fast)
                                return True
        return False

def main():
    s = Solution()
    nums = [2,-1,1,2,2]
    print(s.circularArrayLoop(nums))
    nums = [-1,2]
    print(s.circularArrayLoop(nums))
    nums = [1,2,3,4,5]
    print(s.circularArrayLoop(nums))
    nums = [-2, 1, -1, -2, -2]
    print(s.circularArrayLoop(nums))
    nums = [-1,-2,-3,-4,-5]
    print(s.circularArrayLoop(nums))
if __name__ == '__main__':
    main()
