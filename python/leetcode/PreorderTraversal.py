'''
Leetcode problem No 144 Binary Tree Preorder Traversal
Solution written by Xuqiang Fang on 20 July, 2018
'''
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def preorderTraversal(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        ans = []
        stack = []
        while root or stack:
            if root:
                ans.append(root.val)
            while root:
                if root.left:
                    ans.append(root.left.val)
                stack.append(root)
                root = root.left
            if stack:
                root = stack.pop()
            root = root.right
        return ans

    def preorderTraversal_(self, root):
        '''
        :type root: TreeNode
        :rtype: List[int]
        '''
        ans, stack = [], [(root, False)]
        while stack:
            node, visited = stack.pop()
            if not node:
                continue
            if visited:
                ans.append(node.val)
            else:
                stack.append((node.right, False))
                stack.append((node.left, False))
                stack.append((node, True))
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
    ans = s.preorderTraversal(r)
    for i in ans:
        print(i)
if __name__ == '__main__':
    main()
