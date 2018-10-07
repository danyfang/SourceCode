'''
Leetcode problem No 797 All Paths From Source to Target
Solution written by Xuqiang Fang on 14 Aug, 2018
'''
import collections
class Solution(object):
    def allPathsSourceTarget(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: List[List[int]]
        """
        ans = []
        n = len(graph)
        t = collections.deque([[0]])
        while t:
            a = t.popleft()
            g = graph[a[-1]]
            for s in g:
                aa = a[:]
                aa.append(s)
                if s == n-1:
                    ans.append(aa)
                else:
                    t.append(aa)
        return ans

def main():
    s = Solution()
    graph = [[1,2], [3], [3], []]
    print(s.allPathsSourceTarget(graph))

if __name__ == '__main__':
    main()
