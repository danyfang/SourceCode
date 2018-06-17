'''
Leetcode problem No 4 Median of Two Sorted Arrays
Solution written by Xuqiang Fang on 17 June, 2018
'''
########
'''
An classic problem of finding the medians of two sorted array, time complexity O(m+n)
where m and n are the size of two arrays
'''
class Solution(object):
    def findMedianSortedArrays(self, n1, n2):
        INT_MIN = -2147483648
        INT_MAX = 2147483647
        l1 = len(n1)
        l2 = len(n2)
        k = (l1 + l2 + 1) // 2
        #print('k = %d'%k)
        if l1 > l2 :
            return self.findMedianSortedArrays(n2, n1)
            
        #### l is the number of elements from the first array, l ~[0, l1]
        l = 0
        r = l1
        while l < r:
            m1 = l + (r - l) // 2
            m2 = k - m1 
            if n1[m1] < n2[m2-1]:
                l = m1 + 1
            else:
                r = m1
        m1 = l
        m2 = k - l
        #print('l = %d'%l)
        c1 = max(INT_MIN if m1 <= 0 else n1[m1-1], INT_MIN if m2 <= 0 else n2[m2-1])
        if (l1 + l2 ) % 2 == 1:
            return c1
        c2 = min(INT_MAX if m1 >= l1 else n1[m1], INT_MAX if m2 >= l2 else n2[m2])
        #print('c1 = %d , c2 = %d' %(c1, c2))
        return (c1+c2) / 2.0

def main():
    s = Solution()
    nums1 = [-1,1,3,5,7,9]
    nums2 = [2,4,6,8,10,12,14,16]
    n1 = [2,3]
    n2 = [1,4]
    print(s.findMedianSortedArrays(n1, n2))
main()
