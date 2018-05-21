'''
Leetcode problem No 839 Similar String Groups
Solution written by Xuqiang Fang on 20, 2018
'''

class Solution:
    #TLE
    def numSimilarGroups(self, A):
        """
        :type A: List[str]
        :rtype: int
        """
        if len(A) == 0:
            return 0
        N = len(A)
        graph = [[] for x in range(N)]
        for i in range(N):
            for j in range(N):
                if i != j and self.similar(A[i], A[j]):
                    graph[i].append(j)
                    graph[j].append(i)

        count = 0
        visited = set()
        for i in range(N):
            if i not in visited:
                self.dfs(graph, i, visited)
                count += 1

        return count
    
    def similar(self, a, b):
        count = 0
        for i in range(len(a)):
            if a[i] != b[i]:
                count += 1
        return count == 2

    def dfs(self, graph, node, visited):
        visited.add(node)
        for n in graph[node]:
            if not n in visited:
                self.dfs(graph, n, visited)
        

def main():
    s = Solution()
    A = ["tars","rats","arts","star"]
    print(s.numSimilarGroups(A))

main()
