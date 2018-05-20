'''
Leetcode problem No 110 Balanced Binary Tree
'''
class TreeNode(object):
	def __init__(self, x):
		self.val = x
		self.left = None
		self.right = None
	
class Solution(object):
	def height(self, root):
		if not root:
			return 0
		else: 
			return 1 + max(self.height(root.left), self.height(root.right))
	def isBalanced(self, root):
		if not root:
			return True
		if(abs(self.height(root.left) - self.height(root.right)) > 1):
			return False

		return self.isBalanced(root.left) and self.isBalanced(root.right)
		'''
		:type root: TreeNode
		:rtype: bool
		'''
def main():
    root = TreeNode(1)
    a = TreeNode(2)
    b = TreeNode(2)
    root.left = a
    root.right = b

    c = TreeNode(3)
    d = TreeNode(3)
    e = TreeNode(3)
    f = TreeNode(3)
    a.left = c
    a.right = d
    b.left = e
    b.right = f

    g = TreeNode(4)
    h = TreeNode(4)
    i = TreeNode(4)
    j = TreeNode(4)
    k = TreeNode(4)
    l = TreeNode(4)
    c.left = g
    c.right = h
    d.left = i
    d.right = j
    e.left = k
    e.right = l


    m = TreeNode(5)
    n = TreeNode(5)
    g.left = m
    g.right = n

    s = Solution()
    print(s.isBalanced(root))

main()
