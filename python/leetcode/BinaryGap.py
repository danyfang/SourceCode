'''
Leetcode problem No 868 Binary Gap
Solution written by Xuqiang Fang on 15 July, 2018
'''

class Solution(object):
    def binaryGap(self, N):
        """
        :type N: int
        :rtype: int
        """
        b = str(bin(N))
        for i in range(len(b)):
            if b[i] == '1':
                ans = 0
                prev = i
                for j in range(i+1, len(b)):
                    if b[j] == '1':
                        ans = max(ans, j-prev)
                        prev = j
                if ans != 0:
                    return ans
        return 0

def main():
    s = Solution()
    print(s.binaryGap(22))
    print(s.binaryGap(5))
    print(s.binaryGap(6))
    print(s.binaryGap(8))

if __name__ == '__main__':
    main()
