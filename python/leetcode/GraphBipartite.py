'''
Leetcode problem No 785 Is Graph Bipartite
Solution written by Xuqiang Fang on 21 May, 2018
'''

class Solution(object):
    def isBipartite(self, graph):
        """
        :type graph: List[List[int]]
        :rtype: bool
        """
        dic = {}
        queue = []
        for i in range(len(graph)):
            if not i in dic:
                dic[i] = 0
                queue.append(i)
                while len(queue) > 0:
                    size = len(queue)
                    while size > 0:
                        x = queue.pop(0)
                        tmp = graph[x]
                        for y in tmp:
                            if not y in dic:
                                dic[y] = 1-dic[x]
                                queue.append(y)
                            elif dic[y] == dic[x]:
                                return False
                        size -= 1
        return True

def main():
    s = Solution()
    graph = [[1,3], [0,2], [1,3], [0,2]]
    graph2 = [[1,2,3], [0,2], [0,1,3], [0,2]]
    graph3 = [[],[2,4,6],[1,4,8,9],[7,8],[1,2,8,9],[6,9],[1,5,7,8,9],[3,6,9],[2,3,4,6,9],[2,4,5,6,7,8]]
    print(s.isBipartite(graph))
    print(s.isBipartite(graph2))
    print(s.isBipartite(graph3))

main()
