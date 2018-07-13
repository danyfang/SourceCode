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

def main():
    s = Solution()
    nums = [2,-1,1,2,2]
    print(s.circularArrayLoop(nums))
    nums = [-1,2]
    print(s.circularArrayLoop(nums))
    nums = [1,2,3,4,5]
    print(s.circularArrayLoop(nums))
if __name__ == '__main__':
    main()
