'''
Leetcode problem No 878 Nth Magical Number
Solution written by Xuqiang Fang on 29 July, 2018
'''
import math
class Solution:
    def nthMagicalNumber(self, N, A, B):
        """
        :type N: int
        :type A: int
        :type B: int
        :rtype: int
        """
        mod = 10**9 + 7
        a = min(A, B)
        b = max(A, B)
        if b % a == 0:
            return a * N % mod
        else:
            r = N * a
            l = r // 2
            d = self.lcm(a, b)
            while l < r:
                m = (l + r) // 2
                c = m//a + m // b - m //d
                if c >= N:
                    r = m
                else:
                    l = m+1
            return l % mod
                    
    def lcm(self, a, b):
        return a * b // math.gcd(a, b)
        

def main():
    s = Solution()
    print(s.nthMagicalNumber(1,2,3))

if __name__ == "__main__":
    main()
