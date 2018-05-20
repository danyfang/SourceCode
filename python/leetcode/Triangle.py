'''
Leetcode problem No 120 Triangle
Solution written by Xuqiang Fang on 4 April, 2018
'''

class Solution(object):
    def minimumTotal(self, triangle):
        prev = triangle[0]
        next = triangle[0]
        for i in range(1,len(triangle)):
            next = triangle[i]
            size = len(next)
            next[0] = prev[0] + next[0]
            next[size-1] = prev[size-2] + next[size-1]
            for j in range(1,size-1):
                temp = min(prev[j], prev[j-1])
                next[j] = temp + next[j]
            prev = next
        print(next)
        return min(next)
        '''
        :type triangle list[list[int]]
        :rtype int
        '''

def main():
    triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
    s = Solution()
    print(s.minimumTotal(triangle))
main()
