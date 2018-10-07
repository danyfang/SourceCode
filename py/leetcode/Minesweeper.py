'''
Leetcode problem No 529 Minesweeper
Solution written by Xuqiang Fang on 23 May, 2018 
'''

class Solution(object):
    #first method, use bfs
    def updateBoard(self, board, click):
        """
        :type board: List[List[str]]
        :type click: List[int]
        :rtype: List[List[str]]
        """
        m = len(board)
        n = len(board[0])
        self.dfs(board, m, n, click[0], click[1])
        return board

    def dfs(self,board, m, n, x, y):
        if x<0 or x>=m or y<0 or y>=n or board[x][y] == 'B' or board[x][y].isdigit():
            return
        if board[x][y] == 'M':
            board[x][y] = 'X'
            return
        c = 0
        for i in (-1,0,1):
            for j in (-1,0,1):
                k = x+i
                l = y+j
                if k<0 or k>=m or l<0 or l>=n or (i==0 and j==0):
                    continue
                elif board[k][l] == 'M':
                    c += 1
        if c == 0:
            board[x][y] = 'B'
            self.dfs(board, m, n, x,y-1)
            self.dfs(board, m, n, x,y+1)
            self.dfs(board, m, n, x-1,y-1)
            self.dfs(board, m, n, x-1,y+1)
            self.dfs(board, m, n, x-1,y)
            self.dfs(board, m, n, x+1,y)
            self.dfs(board, m, n, x+1,y-1)
            self.dfs(board, m, n, x+1,y+1)
        else:
            board[x][y] = str(chr(c+ord('0')))
    

    #second method, use bfs, but this solution is TLE
    def updateBoard_bfs(self, board, click):
        if(board[click[0]][click[1]] == 'M'):
            board[click[0]][click[1]] = 'X'
            return board
        m = len(board)
        n = len(board[0])
        q = []
        q.append(click)
        while len(q) > 0:
            size = len(q)
            while size > 0:
                a = q.pop(0)
                c = 0
                for i in (-1,0,1):
                    for j in (-1,0,1):
                        k = a[0]+i
                        l = a[1]+j
                        if k<0 or k>=m or l<0 or l>=n or (i==0 and j==0):
                            continue
                        elif board[k][l] == 'M':
                            c += 1
                if c == 0:
                    board[a[0]][a[1]] = 'B'
                    for i in (-1,0,1):
                        for j in (-1,0,1):
                            k = a[0]+i
                            l = a[1]+j
                            if k<0 or k>=m or l<0 or l>=n or (i==0 and j==0):
                                continue
                            elif board[k][l] == 'E':
                                q.append([k,l])
                                #####################
                                ##Don't forget this, or it causes TLE##
                                board[k][l] = 'B'
                elif c != 0:
                    board[a[0]][a[1]] = str(chr(c+ord('0'))) 
                size -= 1

        return board

def main():
    s = Solution()
    board = [["E","M","M","E","E","E","E","E"],
            ["E","E","M","E","E","E","E","E"],
            ["E","E","E","E","E","E","E","E"],
            ["E","M","E","E","E","E","E","E"],
            ["E","E","E","E","E","E","E","E"],
            ["E","E","M","E","E","E","E","E"],
            ["E","E","E","E","E","E","E","E"],
            ["E","E","E","E","E","E","E","E"]]
    click = [5,5]
    dfs = s.updateBoard(board, click)
    bfs = s.updateBoard_bfs(board, click)
    print(dfs)
    print(bfs)
    print(bfs == dfs)

main()
