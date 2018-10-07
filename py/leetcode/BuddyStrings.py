'''
Leetcode problem No 859 Buddy Strings
Solution written by Xuqiang Fang on 24 June, 2018
'''

class Solution(object):
    def buddyStrings(self, A, B):
        if len(A) != len(B):
            return False
        dica = {}
        dicb = {}
        c = 0
        for i in range(len(A)):
            a = A[i]
            b = B[i]
            if a != b:
                c += 1
            if a not in dica:
                dica[a] = 1
            else:
                dica[a] += 1
            if b not in dicb:
                dicb[b] = 1
            else:
                dicb[b] += 1
        if dica == dicb:
            if c == 2:
                return True
            elif c == 0:
                for key in dica:
                    if dica[key] >= 2:
                        return True
        return False 
def main():
    s = Solution()
    print(s.buddyStrings('ab', 'ba'))
    print(s.buddyStrings('aaaaabc', 'aaaaacb'))
    print(s.buddyStrings('aa', 'aa'))
    print(s.buddyStrings('ab', 'ab'))
    print(s.buddyStrings('ab', 'ca'))
main()
