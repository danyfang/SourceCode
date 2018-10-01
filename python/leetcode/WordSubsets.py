'''
Leetcode problem No 916 Word Subsets
Solution written by Xuqiang Fang on 1 Oct, 2018
'''
from collections import Counter

class Solution(object):
    def wordSubsets(self, A, B):
        """
        :type A: List[str]
        :type B: List[str]
        :rtype: List[str]
        """
        check = Counter()
        for b in B:
            for c, n in Counter(b).items():
                check[c] = max(check[c], n)

        ans = []
        for a in A:
            count = Counter(a)
            if all(count[c] >= check[c] for c in check):
                ans.append(a)
        return ans


def main():
    s = Solution()
    A = ["amazon","apple","facebook","google","leetcode"]; B = ["ec","oc","ceo"]
    print(s.wordSubsets(A, B))
    B = ["lo","eo"]
    print(s.wordSubsets(A, B))
    B = ["l","e"]
    print(s.wordSubsets(A, B))
if __name__ == '__main__':
    main()
