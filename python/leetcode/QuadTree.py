'''
Leetcode problem No 427 Construct Quad Tree
Leetcode problem No 558 Quad Tree Intersection
Solution written by Xuqiang Fang on 13 July, 2018
'''
class Node(object):
    def __init__(self, val, isLeaf, topLeft, topRight, bottomLeft, bottomRight):
        self.val = val
        self.isLeaf = isLeaf
        self.topLeft = topLeft
        self.topRight = topRight
        self.bottomLeft = bottomLeft
        self.bottomRight = bottomRight

class Solution(object):
    def construct(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: Node
        """
        if not grid:
            return None
        if len(grid) == 1:
            return Node(grid[0][0] == 1, True, None, None, None, None)
        n = len(grid) 
        s = sum([sum(x) for x in grid])
        #print(s, n**2)
        if s == n**2:
            #print('leaf node')
            return Node(True, True, None, None, None, None)
        elif s == 0:
            #print('false leaf')
            return Node(False, True, None, None, None, None)

        m = n//2
        #print(m, n)
        tl = self.construct([x[:m] for x in grid[:m]])
        tr = self.construct([x[m:] for x in grid[:m]])
        bl = self.construct([x[:m] for x in grid[m:]])
        br = self.construct([x[m:] for x in grid[m:]])
        '''
        vote = 0
        for v in (tl, tr, bl, br):
            if v.val:
                vote += 1
        ans = Node(vote >= 2, False, tl, tr, bl, br)
        '''
        ans = Node(True, False, tl, tr, bl, br)
        return ans

    def intersect(self, quadTree1, quadTree2):
        """
        :type quadTree1: Node
        :type quadTree2: Node
        :rtype: Node
        """

def print_tree(node):
    if node:
        if not node.isLeaf:
            print_tree(node.topLeft)
            print_tree(node.topRight)
            print_tree(node.bottomLeft)
            print_tree(node.bottomRight)
        print(node.val)
def main():
    s = Solution()
    grid = [
        [1,1,1,1,0,0,0,0],
        [1,1,1,1,0,0,0,0],
        [1,1,1,1,1,1,1,1],
        [1,1,1,1,1,1,1,1],
        [1,1,1,1,0,0,0,0],
        [1,1,1,1,0,0,0,0],
        [1,1,1,1,0,0,0,0],
        [1,1,1,1,0,0,0,0]
    ]
    ans = s.construct(grid)
    #print_tree(ans)
    grid = [[1,1,0,0,0,0,0,0],
            [1,1,0,0,0,0,0,0],
            [1,1,0,0,0,0,1,1],
            [1,1,0,0,0,0,1,1],
            [0,0,0,0,0,0,1,1],
            [0,0,0,0,0,0,1,1],
            [1,1,1,1,1,1,0,0],
            [1,1,1,1,1,1,0,0]
            ]
    ans = s.construct(grid)
    print_tree(ans)

if __name__ == '__main__':
    main()
