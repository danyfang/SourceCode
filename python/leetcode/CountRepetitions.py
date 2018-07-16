'''
Leetcode problem No 466 Count The Repetitions
Solution written by Xuqiang Fang on 14 July, 2018
'''
import collections

class Solution(object):
    def getMaxRepetitions(self, s1, n1, s2, n2):
        """
        :type s1: str
        :type n1: int
        :type s2: str
        :type n2: int
        :rtype: int
        """
        repeat_count = [0] * (len(s2)+1)
        lookup = {}
        j, count = 0, 0
        for k in range(1, n1+1):
            for i in range(len(s1)):
                if s1[i] == s2[j]:
                    j = (j + 1) % len(s2)
                    count += (j == 0)

            if j in lookup:   # cyclic
                i = lookup[j]
                prefix_count = repeat_count[i]
                pattern_count = (count - repeat_count[i]) * ((n1 - i) // (k - i))
                suffix_count = repeat_count[i + (n1 - i) % (k - i)] - repeat_count[i]
                return (prefix_count + pattern_count + suffix_count) // n2
            lookup[j] = k
            repeat_count[k] = count

        return repeat_count[n1] // n2  # not cyclic iff n1 <= s2


def main():
    s = Solution()
    s1 = 'acb'; n1 = 4
    s2 = 'ab'; n2 = 2
    print(s.getMaxRepetitions(s1, n1, s2, n2))
    s1 = 'acbfhksdhfjksfshfasjhfsjffahsfkj'
    s2 = 'abfshdj'
    print(s.getMaxRepetitions(s1, n1, s2, n2))
    s1 = "nlhqgllunmelayl"
    s2 = "lnl"
    n1 = 2
    n2 = 1
    print(s.getMaxRepetitions(s1, n1, s2, n2))
    s1 = "phqghumeaylnlfdxfircvscxggbwkfnqduxwfnfozvsrtkjpre"
    n1 = 1000000
    s2 = "pggxr"
    n2 = 100
    print(s.getMaxRepetitions(s1, n1, s2, n2))
    s1 = "nlhqgllunmelayl"
    n1 = 2
    s2 = "lnl"
    n2 = 1
    print(s.getMaxRepetitions(s1, n1, s2, n2))
    n1 = 10000
    n2 = 10
    print(s.getMaxRepetitions(s1, n1, s2, n2))
    s1 = "niconiconi"
    n1 = 99981
    s2 = "nico"
    n2 = 81
    print(s.getMaxRepetitions(s1, n1, s2, n2))

if __name__ == '__main__':
    main()
