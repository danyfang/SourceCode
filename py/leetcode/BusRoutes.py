'''
Leetcode problem No 815 Bus Routes
Solution written by Xuqiang Fang on 21 June, 2018
'''

class Solution(object):
    def numBusesToDestination(self, routes, S, T):
        """
        :type routes: List[List[int]]
        :type S: int
        :type T: int
        :rtype: int
        """
        ##### solution BFS
        if S == T: 
            return 0
        n = len(routes)
        m = {}
        for i in range(n):
            for r in routes[i]:
                if r not in m:
                    m[r] = [i]
                else:
                    m[r].append(i)
        q = [S]
        ans = 0
        visited = [0] * n
        while len(q) > 0:
            ans += 1
            for i in range(len(q)):
                s = q.pop(0)
                for b in m[s]:
                    if visited[b]:
                        continue
                    visited[b] = 1
                    for t in routes[b]:
                        if t == T:
                            return ans
                        q.append(t)
        return -1

def main():
    s = Solution()
    routes = [[1, 2, 7], [3, 6, 7]]
    print(s.numBusesToDestination(routes, 1, 6))
main()
