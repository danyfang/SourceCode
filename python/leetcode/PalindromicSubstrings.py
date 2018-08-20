'''
Leetcode problem No 647 Palindromic Substrings
Solution written by Xuqiang Fang on 15 Aug, 2018
'''

class Solution(object):
    def countSubstrings(self, s):
        """
        :type s: str
        :rtype: int
        """
        n = len(s)
        ans = 0
        for i in range(2*n-1):
            left = i // 2
            right = left + i % 2
            while left >= 0 and right <n and s[left] == s[right]:
                ans += 1
                left -= 1
                right += 1
        return ans

        '''
        the following naive solution is TLE
        def isPalin(t):
            l = 0; r = len(t)-1
            if r < 0:
                return False
            while l < r:
                if t[l] != t[r]:
                    return False
                l += 1; r -= 1
            return True
        n = len(s)
        ans = 0
        for i in range(n):
            ans += 1
            for j in reversed(range(i)):
                if isPalin(s[j:i+1]):
                    ans += 1
        return ans
        '''

    def manacher(self, s):
        '''
        O(n) solution for longest palindrome substring
        '''
        A = '#' + '#'.join(s) + '#'
        c= 0; r = -1; rad = 0; n = len(A)
        P = [0] * n
        for i in range(n):
            if i <= r:
                rad = min(P[2*c-i], r-i)
            else:
                rad = 0
            while i+rad < n and i-rad >= 0 and A[i-rad] == A[i+rad]:
                rad += 1
            P[i] = rad
            if i + rad - 1 > r:
                c = i
                r = i + rad - 1
        t = sum([v//2 for v in P])
        ## return this if to calculate longest palindome
        return max(P)-1
        ## return this if to calculate total palidoromic substrings
        #return t
        

def main():
    s = Solution()
    print(s.countSubstrings('abc'))
    print(s.countSubstrings('aaa'))
    print(s.manacher('aaa'))
    def manachers(S):
        A = '@#' + '#'.join(S) + '#$'
        Z = [0] * len(A)
        center = right = 0
        for i in range(1, len(A) - 1):
            if i < right:
                Z[i] = min(right - i, Z[2 * center - i])
            while A[i + Z[i] + 1] == A[i - Z[i] - 1]:
                Z[i] += 1
            if i + Z[i] > right:
                center, right = i, i + Z[i]
        return Z
    print(manachers('aaaaa'))

if __name__ == '__main__':
    main()
