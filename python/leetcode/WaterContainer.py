'''
Leetcode problem No 11 Container With Most Water
Solution written by Xuqiang Fang on 17 June, 2018
'''

class Solution(object):
    def maxArea(self, h):
        l = 0; r = len(h)-1
        m = min(h[l], h[r])*(r-l)
        while l < r:
            if h[l] < h[r]:
                l += 1
                m = max(m, min(h[l], h[r])*(r-l))
            else:
                r -= 1
                m = max(m, min(h[l], h[r])*(r-l))
        return m

def main():
    s = Solution()
    height = [1,3,2,4]
    print(s.maxArea(height))
main()
