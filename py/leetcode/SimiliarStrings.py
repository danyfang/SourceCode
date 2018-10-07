'''
Leetcode problem No 854 K-Similar Strings
Solution written by Xuqiang Fang on 20 June, 2018
'''

class Solution(object):
    def kSimilarity(self, A, B):
        """
        :type A: str
        :type B: str
        :rtype: int
        """
        n = len(A)
        if A == B:
            return 0
        v = set()
        q = []
        v.add(A)
        q.append(A)
        step = 0
        while len(q) > 0:
            step += 1
            t = len(q)
            for x in range(t):
                a = q.pop(0)
                i = 0
                while a[i] == B[i]:
                    i += 1
                for j in range(i+1, n):
                    if a[j] == B[i] and a[j] != B[j]:
                        tmp = list(a)
                        tmp[i] = a[j]
                        tmp[j] = a[i]
                        c = ''.join(tmp)
                        if c == B:
                            return step
                        elif c not in v:
                            v.add(c)
                            q.append(c)
        return step

def main():
    s = Solution()
    print(s.kSimilarity("abcdefgjhijklmnrp", "rnmlkjihpgjfedcba"))
    print(s.kSimilarity("abcdkefgjhlmnjrpqio", "rnmlkjpihqgjfoedcba"))
    print(s.kSimilarity("abc", "bca"))
    print(s.kSimilarity("aabbccddee","cbeddebaac"))
    print(s.kSimilarity("abccaacceecdeea", "bcaacceeccdeaae")) ## should be 9
main()

