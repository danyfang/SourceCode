'''
Leetcode problem No 914 X of a Kind in a Deck of Cards
Solution written by Xuqiang Fang on 1 Oct, 2018
'''

class Solution(object):
    def hasGroupsSizeX(self, deck):
        """
        :type deck: List[int]
        :rtype: bool
        """
        N = 1000
        d = [0 for _ in range(N)]
        for t in deck:
            d[t] += 1
        for x in range(2, len(deck)+1):
            flag = False
            for i in range(N):
                if d[i] % x != 0:
                    flag = True
                    break
            if not flag:
                return True
        return False

def main():
    s = Solution()
    deck = [1,1,1,2,2,2,3,3]
    print(s.hasGroupsSizeX(deck))
    deck = [1,2,3,4,4,3,2,1]
    print(s.hasGroupsSizeX(deck))

if __name__ == '__main__':
    main()
