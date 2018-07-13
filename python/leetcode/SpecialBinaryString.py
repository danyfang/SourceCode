'''
Leetcode problem No 761 Speical Binary String
Solution written by Xuqiang Fang on 11 July, 2018
'''
import functools
def mycomp(a, b):
    l = min(len(a), len(b))
    for i in range(l):
        if a[i] != b[i]:
            if int(a[i])-int(b[i]) > 0:
                return -1
            return 1
    return len(a)-len(b)

class Solution(object):
    def makeLargestSpecial(self, S):
        """
        :type S: str
        :rtype: str
        """
        ans = []
        prev = 0; c = 0
        for i, v in enumerate(S):
            c += 1 if v == '1' else -1
            if c == 0:
                ans.append('1{}0'.format(self.makeLargestSpecial(S[prev+1: i])))
                prev = i + 1
        ans.sort(key = functools.cmp_to_key(mycomp))
        return ''.join(ans)
def main():
    s = Solution()
    S = "11011000"
    print(s.makeLargestSpecial(S))
    S = '101011110000101010111111000000'
    print(s.makeLargestSpecial(S))
    S = '111010011000'
    print(s.makeLargestSpecial(S))
    S = "101011001110011010001111100000"
    print(s.makeLargestSpecial(S))
    print("111110000011101001100011001010")
main()
