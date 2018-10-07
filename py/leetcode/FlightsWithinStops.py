'''
Leetcode problem No 787 Cheapest Flights Within K Stops
Solution written by Xuqiang Fang on 21 May, 2018
'''

class Solution(object):
    def findCheapestPrice(self, n, flights, src, dst, K):
        """
        :type n: int
        :type flights: List[List[int]]
        :type src: int
        :type dst: int
        :type K: int
        :rtype: int
        """
        maxPrice = 10**9
        cost = [maxPrice for x in range(n)]
        cost[src] = 0
        for i in range(K+1):
            tmp = cost.copy();
            for f in flights:
                tmp[f[1]] = min(tmp[f[1]], tmp[f[0]] + f[2])
            cost = tmp.copy()
        return -1 if cost[dst] == maxPrice else cost[dst]

    ## dfs solution

    ## bfs solution
    def findCheapestPrice_bfs(self, n, flights, src, dst, K):
        graph = {}
        for f in flights:
            if not f[0] in graph:
                graph[f[0]] = []
            graph[f[0]].append([f[1], f[2]])
        ans = 10**9
        queue = []
        queue.append([src, 0])
        steps = 0
        while len(queue) > 0:
            size = len(queue)
            while size > 0:
                p = queue.pop(0)
                if p[0] == dst:
                    ans = min(ans, p[1])
                if p[0] in graph:
                    for n in graph[p[0]]:
                        #pruning, the cost is already bigger than current one
                        if n[1] + p[1] > ans:
                            continue
                        queue.append([n[0], n[1]+p[1]])
                size -= 1
            if steps > K:
                break
            steps += 1
        return -1 if ans == 10**9 else ans

def main():
    s = Solution()
    edges = [[0,1,100],[1,2,100],[0,2,500]]
    flights = [[0,1,2],[1,2,1],[2,0,10]]
    print(s.findCheapestPrice(3, edges, 0, 2, 1))
    print(s.findCheapestPrice_bfs(3, edges, 0, 2, 1))

main()
