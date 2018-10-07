'''
Leetcode problem No 834 Sum of Distances in Tree
Solution written by Xuqiang Fang on 19 July, 2018
'''

class Solution(object):
    def sumOfDistancesInTree(self, N, edges):
        """
        :type N: int
        :type edges: List[List[int]]
        :rtype: List[int]
        """
        graph = [set() for _ in range(N)]
        for e in edges:
            if e[1] not in graph[e[0]]:
                graph[e[0]].add(e[1])
            if e[0] not in graph[e[1]]:
                graph[e[1]].add(e[0])

    def postOrder(self, )


def main():
    s = Solution()
