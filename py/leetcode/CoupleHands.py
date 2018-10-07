'''
Leetcode problem No 765 Couples Holding Hands
Solution written by Xuqiang Fang on 20 June, 2018
'''

class Solution(object):
    def minSwapsCouples(self, row):
        """
        :type row: List[int]
        :rtype: int
        """
        n = len(row)
        ptn = [0] * n
        pos = [0] * n
        ans = 0
        for i in range(n):
            ptn[i] = i+1 if i%2 == 0 else i-1
            pos[row[i]] = i
        for i in range(n):
            j = ptn[pos[ptn[row[i]]]]
            while i != j:
                self.swap(row, i, j)
                self.swap(pos, row[i], row[j])
                ans += 1
                j = ptn[pos[ptn[row[i]]]]
        return ans
    def swap(self, l, i, j):
        t = l[i]
        l[i] = l[j]
        l[j] = t

def main():
    s = Solution()
    print(s.minSwapsCouples([3,2,0,1]))
    print(s.minSwapsCouples([0,2,1,3]))
main()
