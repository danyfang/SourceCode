'''
Leetcode problem No 700 Search in a Binary Search Tree
Solution written by Xuqiang Fang on 12 July, 2018
'''
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def searchBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        if not root:
            return None
        elif root.val == val:
            return root

        left = self.searchBST(root.left, val)
        if left:
            return left
        right = self.searchBST(root.right, val)
        if right:
            return right
        return None
        

def main():
    s = Solution()
    r = TreeNode(4)
    a = TreeNode(2)
    b = TreeNode(7)
    c = TreeNode(1)
    d = TreeNode(3)
    r.left = a
    r.right = b
    a.left = c
    a.right = d
    node = s.searchBST(r, 2)
    if node:
        print(node.val)

if __name__ == '__main__':
    main()
