'''
Leetcode problem No 890 Possible Bipartition
Solution written by Xuqiang Fang on 12 Aug, 2018
'''

class Solution(object):
    def possibleBipartition(self, N, dislikes):
        """
        :type N: int
        :type dislikes: List[List[int]]
        :rtype: bool
        """
        if not dislikes:
            return True
        dic = {}; N += 1
        for d in dislikes:
            x = d[0]; y = d[1]
            if x not in dic:
                dic[x] = []
            if y not in dic:
                dic[y] = []
            dic[x].append(y)
            dic[y].append(x)
        color = [0] * N
        return self.bfs(dic, color, dislikes[0][0], 1)

    def bfs(self, dic, color, i, c):
        if color[i] + c == 0:
            return False
        elif color[i] == c:
            return True
        color[i] = c
        for d in dic[i]:
            if not self.bfs(dic, color, d, 0-c):
                return False
        return True

def main():
    s = Solution()
    dislikes = [[1,2],[1,3],[2,4]]
    print(s.possibleBipartition(4, dislikes))
    dislikes = [[1,2],[1,3],[2,3]]
    print(s.possibleBipartition(3, dislikes))
    dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
    print(s.possibleBipartition(5, dislikes))

if __name__ == '__main__':
    main()
