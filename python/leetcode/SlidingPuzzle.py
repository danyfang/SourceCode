'''
Leetcode problem No 773 Sliding Puzzle
Solution written by Xuqiang Fang on 21 May, 2018
'''

class Solution(object):
    def slidingPuzzle(self, board):
        """
        :type board: List[List[int]]
        :rtype: int
        """
        move = {}
        move[0] = [1,3];move[1] = [0,2,4];move[2] = [1,5]
        move[3] = [0,4];move[4] = [1,3,5];move[5] = [2,4]
        final = [1,2,3,4,5,0]
        final = tuple(final)
        queue = []
        state = []
        visited = set()
        for i in range(len(board)):
            for j in range(len(board[i])):
                state.append(board[i][j])
        queue.append(state)
        visited.add(tuple(state))
        if tuple(state).__eq__(final):
            return 0
        step = 0
        while len(queue) > 0:
            step += 1
            size = len(queue)
            while size > 0:
                tmp = queue.pop(0)
                index = tmp.index(0)
                for n in move[index]:
                    self.swap(tmp, index, n)
                    if tuple(tmp) == final:
                        return step
                    elif tuple(tmp) in visited:
                        self.swap(tmp, n, index)
                        continue
                    visited.add(tuple(tmp))
                    queue.append(tmp.copy())
                    self.swap(tmp,n,index)
                size -= 1
        return -1

    
    def swap(self, state, i, j):
        #print('before')
        #print(state)
        c = state[i]
        state[i] = state[j]
        state[j] = c
        #print('after')
        #print(state)

def main():
    s = Solution()
    board = [[1,2,3],[4,0,5]]
    print(s.slidingPuzzle(board))
    print(s.slidingPuzzle([[1,2,3],[5,4,0]]))
    print(s.slidingPuzzle([[4,1,2],[5,0,3]]))
    print(s.slidingPuzzle([[3,2,4],[1,5,0]]))

main()
