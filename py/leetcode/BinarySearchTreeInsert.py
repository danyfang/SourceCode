'''
Leetcode problem No 701 Insert into a Binary Search Tree
Solution written by Xuqiang Fang on 13 July, 2018
'''
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def insertIntoBST(self, root, val):
        """
        :type root: TreeNode
        :type val: int
        :rtype: TreeNode
        """
        if not root:
            root = TreeNode(val)
            return root
        elif val < root.val:
            root.left = self.insertIntoBST(root.left, val)
            return root
        else:
            root.right = self.insertIntoBST(root.right, val)
            return root
def print_tree(root):
    if root:
        print_tree(root.left)
        print(root.val)
        print_tree(root.right)

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
    print('before insertion:') 
    print_tree(r)
    print('after insertion:')
    s.insertIntoBST(r, 5)
    print_tree(r)
if __name__ == '__main__':
    main()
