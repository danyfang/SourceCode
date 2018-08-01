'''
Leetcode problem No 818 Race Car
Solution written by Xuqiang Fang on 30 July, 2018
'''

class Solution(object):
    def racecar(self, t):
        """
        :type target: int
        :rtype: int
        """
        d = [0 for _ in range(t+1)]
        return self.helper(d, t)

    def helper(self, d, t):
        if d[t] > 0:
            return d[t]
        s = 1; n = 0
        while s < t+1:
            s *= 2
            n += 1
        if s == t+1:
            d[t] = n
            return n
        d[t] = n + 1 + self.helper(d, s-t-1)
        s //= 2
        for m in range(n-1):
            position = s - (1<<m)
            d[t] = min(d[t], n+1+m+self.helper(d, t-position)) 
        return d[t]

def main():
    s = Solution()
    print(s.racecar(3))
    print(s.racecar(7))
    print(s.racecar(9))
    print(s.racecar(322))

if __name__ == '__main__':
    main()
