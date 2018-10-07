'''
Leetcode problem No 667 Beautiful Arrangement II
Solution written by Xuqiang Fang on 15 May, 2018
'''

class Solution(object):
    def constructArray(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: List[int]
        """ 
        ans = list(range(1, n-k))
        for d in range(k+1):
            if d % 2 == 0:
                ans.append(n-k+d//2)
            else:
                ans.append(n-d//2)
        return ans

def main():
    s = Solution()
    print(s.constructArray(5,3))

main()
