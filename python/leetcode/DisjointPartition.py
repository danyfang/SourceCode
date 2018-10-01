'''
Leetcode problem No 915 Partition Array into Disjoint Intervals
Solution written by Xuqiang Fang on 1 Oct, 2018
'''

class Solution(object):
    def partitionDisjoint(self, A):
        """
        :type A: List[int]
        :rtype: int
        """
        head = [A[0] for _ in range(len(A))]
        tail = [A[-1] for _ in range(len(A))]
        for i in range(1, len(A)):
            head[i] = max(head[i-1], A[i])

        for i in reversed(range(0,len(A)-1)):
            tail[i] = min(tail[i+1], A[i])

        ans = A[0]
        for i in range(len(A)-1):
            if head[i] <= tail[i+1]:
                ans = i+1
                break
        return ans

def main():
    s = Solution()
    A = [5,0,3,8,6]
    print(s.partitionDisjoint(A))
    A = [1,1,1,0,6,12]
    print(s.partitionDisjoint(A))

if __name__ == '__main__':
    main()
