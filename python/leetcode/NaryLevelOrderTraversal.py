'''
Leetcode problem No 429 N-ary Tree Level Order Traversal
Leetcode problem No 559 Maximum Depth of N-ary Tree
Leetcode problem No 590 N-ary Tree Postorder Traversal
Leetcode problem No 589 N-ary Tree Preorder Traversal
Solution written by Xuqiang Fang on 12 July, 2018
'''

class Node(object):
    def __init__(self, val, children):
        self.val = val
        self.children = children

import collections
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Node
        :rtype: List[List[int]]
        """
        if not root:
            return []
        ans = []
        q = collections.deque([root])
        while q:
            s = len(q)
            level = []
            while s > 0:
                s -= 1
                curr = q.popleft()
                level.append(curr.val)
                if curr.children:
                    q.extend(curr.children)
            ans.append(level)
        return ans

    def maxDepth(self, root):
        """
        :type root: Node
        :rtype: int
        """   
        if not root:
            return 0
        if not root.children:
            return 1
        level = []
        for n in root.children:
            level.append(self.maxDepth(n))
        return 1 + max(level)

    def postorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []
        if not root.children:
            return [root.val]
        ans = []
        for n in root.children:
            ans.extend(self.postorder(n))
        ans.append(root.val)
        return ans

    def preorder(self, root):
        """
        :type root: Node
        :rtype: List[int]
        """
        if not root:
            return []
        ans = [root.val]
        for n in root.children:
            ans.extend(self.preorder(n))
        return ans

def main():
    s = Solution()
    b = Node(2,[])
    c = Node(4,[])
    d = Node(5,[])
    e = Node(6,[])
    a = Node(3,[d,e])
    r = Node(1,[a, b, c])
    print(s.levelOrder(r))
    print(s.maxDepth(r))
    print(s.postorder(r))
    print(s.preorder(r))

if __name__ == '__main__':
    main()
    

