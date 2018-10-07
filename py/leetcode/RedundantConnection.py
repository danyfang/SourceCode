'''
Leetcode problem No 684 Redundant Connection
Solution written by Xuqiang Fang on 12 June, 2018
'''

class Solution(object):
    '''
    union find 
    '''
    def findRedundantConnection(self, edge):
        n = len(edge)
        p = [0 for x in range(n+1)]
        s = [1 for x in range(n+1)]
        for e in edge:
            u = e[0]; v = e[1]
            if p[u] == 0:
                p[u] = u
            if p[v] == 0:
                p[v] = v
            pu = self.find(u, p)
            pv = self.find(v, p)
            if pu == pv:
                return e
            if s[pv] > s[pu]:
               t = pu
               pu = pv
               pv = t
            p[pv] = pu
            s[pu] += s[pv]
        return [None, None]
                
    
    def find(self, child, parent):
        while(child != parent[child]):
            parent[child] = parent[parent[child]]
            child = parent[child]
        return child

def main():
    s = Solution()
    edge = [[1,2],[1,3],[2,3]]
    edg = [[1,2],[2,3],[3,4],[1,4],[1,5]]
    print(s.findRedundantConnection(edge))
    print(s.findRedundantConnection(edg))
main()
