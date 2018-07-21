'''
Leetcode problem No 94 Binary Tree Inorder Traversal
Solution written by Xuqiang Fang on 20 July, 2018
'''

class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def inorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans, stack = [], [(root, False)]
        while stack:
            root, visited = stack.pop()
            if not root:
                continue
            if visited:
                ans.append(root.val)
            else:
                stack.append((root.right, False))
                stack.append((root, True))
                stack.append((root.left, False))
        return ans

def main():
    s = Solution()
    r = TreeNode(1)
    a = TreeNode(2)
    b = TreeNode(3)
    c = TreeNode(4)
    d = TreeNode(5)
    r.left = a
    r.right = b
    a.left = c
    a.right = d
    ans = s.inorderTraversal(r)
    for i in ans:
        print(i)
if __name__ == '__main__':
    main()
