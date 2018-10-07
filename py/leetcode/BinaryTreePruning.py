'''
Leetcode problem No 814 Binary Tree Pruning
Solution written by Xuqiang Fang on 24 July, 2018
'''
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

    
class Solution(object):
    def pruneTree(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root or self.sumTree(root) == 0:
            return None
        root.left = self.pruneTree(root.left)
        root.right = self.pruneTree(root.right)
        return root
    
    def sumTree(self, root):
        if not root:
            return 0
        elif not root.left and not root.right:
            return root.val
        return root.val + self.sumTree(root.left) + self.sumTree(root.right)

def printTree(root):
    if root:
        printTree(root.left)
        print(root.val)
        printTree(root.right)
        
def main():
    s = Solution()
    a = TreeNode(1)
    b = TreeNode(0)
    c = TreeNode(0)
    d = TreeNode(1)
    a.right = b
    b.left = c
    b.right = d
    print('before prune')
    printTree(a)
    s.pruneTree(a)
    print('after prune')
    printTree(a)

main()
