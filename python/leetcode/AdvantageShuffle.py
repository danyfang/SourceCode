'''
Leetcode problem No 870 Advantage Shuffle
Solution written by Xuqiang Fang on 16 July, 2018
'''

class Solution(object):
    def advantageCount(self, A, B):
        """
        :type A: List[int]
        :type B: List[int]
        :rtype: List[int]
        """
        A.sort()
        ans = []
        for b in B:
            l = 0; r = len(A)
            while l < r:
                m = (l + r) // 2
                if A[m] <= b:
                    l = m + 1
                else:
                    r = m
            if l < len(A) and A[l] > b:
                ans.append(A[l])
                del A[l]
            else:
                ans.append(A[0])
                del A[0]
        return ans


def main():
    s = Solution()
    A = [12,24,8,32]; B = [13,25,32,11]
    print(s.advantageCount(A, B))
    A = [2,7,11,15]; B = [1,10,4,11]
    print(s.advantageCount(A, B))
if __name__ == '__main__':
    main()
