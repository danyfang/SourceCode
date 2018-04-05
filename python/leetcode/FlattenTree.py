'''
Leetcode problem 114 Flatten Binary Tree to Linked List
Solution written by Xuqiang Fang on 3 April, 2018
'''
class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def flatten(self, root):
        if(root == None):
            exit
        l = self.getList(root)
        if(len(l) == 0):
            exit
        cur = l[0]
        for i in range(1, len(l)):
            cur.left = None
            cur.right = l[i]
            cur = cur.right

    def getList(self, root):
        l = []
        if(root != None):
            l.append(root)
            l += self.getList(root.left)
            l += self.getList(root.right)
        return l

root = TreeNode(1)
a = TreeNode(2)
b = TreeNode(5)
c = TreeNode(3)
d = TreeNode(4)
e = TreeNode(6)
root.left = a
root.right = b
a.left = c
a.right = d
b.right = e
s = Solution()
s.flatten(root)
while(root != None):
    print root.val
    root = root.right
