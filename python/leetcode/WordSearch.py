'''
Leetcode problem No 212 Word Search II
Leetcode problem No 79 Word Search I
Solution written by Xuqiang Fang on 13 June, 2018
'''

class Solution(object):
    '''
    # Unfortunately using plain dfs is TLE
    '''
    def findWords(self, board, words):
        """
        :type board: List[List[str]]
        :type words: List[str]
        :rtype: List[str]
        """
        m = len(board)
        ans = []
        if m == 0:
            return ans
        n = len(board[0])
        for w in words:
            for i in range(m):
                for j in range(n):
                    if(board[i][j] == w[0]):
                        self.dfs(ans, board.copy(), w, m, n, i, j, 1)
        return ans
    def dfs(self, ans, board, w, m, n, i, j, x):
        if x == len(w):
            if not w in ans:
                ans.append(w)
            return
        else:
            t = board[i][j]
            board[i][j] = '.'
            if i-1 >= 0 and board[i-1][j] == w[x]:
                self.dfs(ans, board, w, m, n, i-1, j, x+1)
            if i+1 < m and board[i+1][j] == w[x]:
                self.dfs(ans, board, w, m, n, i+1, j, x+1)
            if j-1 >= 0 and board[i][j-1] == w[x]:
                self.dfs(ans, board, w, m, n, i, j-1, x+1)
            if j+1 < n and board[i][j+1] == w[x]:
                self.dfs(ans, board, w, m, n, i, j+1, x+1)
            board[i][j] = t

    ################# for No 79
    def exist(self, board, word):
        """
        :type board: List[List[str]]
        :type word: str
        :rtype: bool
        """
        if not board or not board[0] or not word:
            return False
        m, n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if self.dfs_(board, word, m, n, i, j, 0):
                    return True
        return False
    def dfs_(self, board, word, m, n, i, j, x):
        if i<0 or i>=m or j<0 or j>=n or board[i][j] != word[x]:
            return False
        if x == len(word)-1:
            return True
        c = board[i][j]
        board[i][j] = '#'
        if self.dfs_(board, word, m, n, i+1, j, x+1):
            return True
        if self.dfs_(board, word, m, n, i-1, j, x+1):
            return True
        if self.dfs_(board, word, m, n, i, j+1, x+1):
            return True
        if self.dfs_(board, word, m, n, i, j-1, x+1) :
            return True
        board[i][j] = c
        return False

## another idea, use trie and dfs
class Xuqiang:
    def findWords(self, board, words):
        if not board or not board[0]:
            return []
        #build a trie
        root = {}
        for w in words:
            p = root
            for c in w:
                if c not in p:
                    p[c] = {}
                p = p[c]
            p['#'] = w
        ans = []
        m,n = len(board), len(board[0])
        for i in range(m):
            for j in range(n):
                if board[i][j] in root:
                    self.dfs(board, root, m, n, i, j, ans)
        return ans
    def dfs(self, board, root, m, n, i, j, ans):
        node = root[board[i][j]]
        if '#' in node:
            ans.append(node['#'])
            node.pop('#')
        c = board[i][j]
        board[i][j] = '#'
        for x,y in ((i-1, j), (i+1, j), (i, j-1), (i, j+1)):
            if 0<=x<m and 0<=y<n and board[x][y] != '#' and board[x][y] in node:
                self.dfs(board, node, m, n, x, y, ans)
        board[i][j] = c
        
def main():
    s = Solution()
    words = ["oath","pea","eat","rain"]
    board = [
              ['o','a','a','n'],
              ['e','t','a','e'],
              ['i','h','k','r'],
              ['i','f','l','v']
            ]
    boar = [
              ['A','B','C','E'],
              ['S','F','C','S'],
              ['A','D','E','E']
            ]
    print(s.findWords(board, words))
    x = Xuqiang()
    print(x.findWords(board, words))
    w1 = 'ABCCED' #true
    w2 = 'SEE' # true
    w3 = 'ABCB' #true
    #print(s.exist(boar, w1))
    print(s.exist(boar, w2))
    print(s.exist(boar, w3))
main()
