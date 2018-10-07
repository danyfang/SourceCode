'''
Leetcode problem No 102 Binary Tree Level Order Traversal
Leetcode problem No 107 Binary Tree Level Order Traversal II
Solution written by Xuqiang Fang on 20 July, 2018
'''
import collections
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        ans, queue = [], collections.deque([root])
        while queue:
            size = len(queue)
            tmp = []
            while size > 0:
                size -= 1
                node = queue.popleft()
                if node:
                    tmp.append(node.val)
                    queue.append(node.left)
                    queue.append(node.right)
            if tmp:
                ans.append(tmp)
        return ans
    def levelOrderBottom(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        return self.levelOrder(root)[::-1]

def main():
    s = Solution()
    r = TreeNode(1)
    a = TreeNode(2)
    b = TreeNode(3)
    c = TreeNode(4)
    d = TreeNode(5)
    e = TreeNode(6)
    f = TreeNode(7)
    r.left = a
    r.right = b
    a.left = c
    a.right = d
    b.left = e
    b.right = f
    ans = s.levelOrder(r)
    for i in ans:
        print(i)
    ans = s.levelOrderBottom(r)
    for i in ans:
        print(i)
if __name__ == '__main__':
    main()
