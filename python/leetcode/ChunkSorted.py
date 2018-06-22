'''
Leetcode problem No 768 Max Chunks To Make Sorted II
Leetcode problem No 769 Max Chunks To Make Sorted 
Solution written by Xuqiang Fang on 21 June, 2018
'''

class Solution(object):
    ## No 769
    def maxChunksToSorted_(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        if n == 0:
            return 0
        m = arr[0]
        ans = 0
        for i in range(n):
            m = max(m, arr[i])
            if m == i:
                ans += 1
        return ans

    ## No 768
    def maxChunksToSorted_(self, arr):
        """
        :type arr: List[int]
        :rtype: int
        """
        n = len(arr)
        if n == 0:
            return 0
        c = arr.copy()
        m = c[0]
        arr.sort()
        ans = 0
        prev = 0
        for i in range(n):
            m = max(m, c[i])
            if m == arr[i]:
                #print('i=%d'%i)
                count = 0
                for j in range(prev,i+1):
                    if m == c[j]:
                        count += 1
                    if m == arr[j]:
                        count -= 1
                if count == 0:
                    ans += 1
                    prev = i+1
                
        return ans
    def maxChunksToSorted(self, arr):
        n = len(arr)
        if n == 0:
            return 0
        left = [arr[0] for x in range(n)]
        right = [arr[n-1] for x in range(n)]
        for i in range(1,n):
            left[i] = max(left[i-1], arr[i])
        for i in range(n-2, -1, -1):
            right[i] = min(right[i+1], arr[i])
        ans = 0
        for i in range(n-1):
            if left[i] <= right[i+1]:
                ans += 1
        return ans+1
def main():
    s = Solution()
    arr = [2,1,3,4,0]
    print(s.maxChunksToSorted(arr))
    arr = [2,1,3,4,4]
    print(s.maxChunksToSorted(arr))
    arr = [1,1,0,0,1] ## should be 2
    print(s.maxChunksToSorted(arr))
main()
