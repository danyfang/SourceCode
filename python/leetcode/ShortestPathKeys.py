'''
Leetcode problem No 865 Shortest Path to Get All Keys
Solution written by Xuqiang Fang on 8 July, 2018
'''
import collections
class Solution(object):
    def shortestPathAllKeys(self, grid):
        """
        :type grid: List[str]
        :rtype: int
        """
        m = len(grid)
        n = len(grid[0])
        start = (0,0,0); keys = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == '@':
                    start = (i, j, 0)
                elif ord(grid[i][j]) >= ord('a') \
                and ord(grid[i][j]) <= ord('f'):
                    keys += 1
        ans = (1 << keys) - 1
        q = collections.deque([start])
        dirs = [(0, 1), (1, 0), (0, -1), (-1,0)]
        visited = set()
        visited.add(start)
        step = 0
        while q:
            t = len(q)
            while t > 0:
                t -= 1
                curr = q.popleft()
                k = curr[2]
                if k == ans:
                    return step
                #print(step , curr)
                for d in dirs:
                    x = curr[0] + d[0]
                    y = curr[1] + d[1]
                    k = curr[2] # watch out that the key may change after this
                    if x>=0 and x<m and y>=0 and y<n:
                        if grid[x][y] == '#':
                            continue
                        value = ord(grid[x][y])
                        if value >= ord('a') and value <= ord('f'):
                            k |= (1 << (value-ord('a'))) # key change here
                        if value >= ord('A') and value <= ord('F') and (k >> (value-ord('A'))&1) == 0:
                            continue
                        if (x,y,k) not in visited:
                            visited.add((x,y,k))
                            q.append((x,y,k))
            step += 1
        return -1
    

def main():
    s = Solution()
    grid = ["@.a.#","###.#","b.A.B"]
    print(s.shortestPathAllKeys(grid))
    grid = ["@..aA","..B#.","....b"]
    print(s.shortestPathAllKeys(grid))
    grid = [".@aA"]
    print(s.shortestPathAllKeys(grid))
    grid = ["@...a",".###A","b.BCc"] # 10
    print(s.shortestPathAllKeys(grid))
    grid = [".#.b.","A.#aB","#d...","@.cC.","D...#"]
    for g in grid:
        print(g)
    print(s.shortestPathAllKeys(grid))
    grid = ["@abcdeABCDEFf"]
    print(s.shortestPathAllKeys(grid))
main()
