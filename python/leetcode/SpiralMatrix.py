'''
Leetcode problem No 889 Spiral Matrix III
Solution written by Xuqiang Fang on 12 Aug, 2018
'''

class Solution:
    def spiralMatrixIII(self, R, C, r0, c0):
        """
        :type R: int
        :type C: int
        :type r0: int
        :type c0: int
        :rtype: List[List[int]]
        """
        ans = []
        dirs = ((0,1), (1,0), (0, -1), (-1, 0))
        step = 1; i = 0
        curr = [r0, c0]
        ans.append(curr[:])
        while len(ans) < R * C:
            d = dirs[i]
            x = curr[0]; y = curr[1]
            if i % 2 == 0:
                c = 0
                while c < step:
                    c += 1
                    y = curr[1] + c * d[1]
                    if x >= 0 and x < R and y >= 0 and y < C:
                        ans.append([x, y])

            else:
                c = 0
                while c < step:
                    c += 1
                    x = curr[0] + c * d[0]
                    if x >= 0 and x < R and y >= 0 and y < C:
                        ans.append([x, y])
            curr = [x, y]
            i += 1
            i %= 4
            if i % 2 == 0:
                step += 1
        return ans
            

def main():
    s = Solution()
    print(s.spiralMatrixIII(1,4,0,0))

if __name__ == '__main__':
    main()
