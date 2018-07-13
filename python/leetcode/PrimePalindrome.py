'''
Leetcode problem No 867 Prime Palindrome
Solution written by Xuqiang Fang on 8 July, 2018
'''
import math
class Solution(object):
    def primePalindrome(self, N):
        """
        :type N: int
        :rtype: int
        """
        def isPrime(x):
            if x < 2 or x % 2 == 0: return x == 2
            for i in range(3, int(x**0.5) + 1, 2):
                if x % i == 0: return False
            return True
        if 8 <= N and N <= 11:
            return 11
        i = len(str(N)) // 2
        for x in range(1, 10**5):
            y = int(str(x) + str(x)[-2::-1]) 
            if isPrime(y) and y >= N:
                return y
        return -1
    def primePalindrome_(self, N):
        def isPrime(x):
            if x < 2 or x % 2 == 0: return x == 2
            for i in range(3, int(x**0.5) + 1, 2):
                if x % i == 0: return False
            return True
        if 8 <= N <= 11: return 11
        for x in range(10 ** (len(str(N)) / 2), 10**5):
            y = int(str(x) + str(x)[-2::-1])
            if y >= N and isPrime(y): return y
def main():
    s = Solution()
    print(s.primePalindrome(3))
    print(s.primePalindrome(6))
    print(s.primePalindrome(9))
    print(s.primePalindrome(10))
    print(s.primePalindrome(13))
    print(s.primePalindrome(130))
    print(s.primePalindrome(3304033))
    print(s.primePalindrome(1300000))
    print(s.primePalindrome(10000000))
main()
