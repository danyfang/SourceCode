'''
Leetcode problem No 124 Binary Tree Maximum Path Sum
Solution written by Xuqiang Fang on 3 July, 2018
'''
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution(object):
    ans = float('-inf')
    def maxPathSum(self, root):
        if root is None:
            return 0
        self.helper(root)
        return self.ans

    def helper(self, root):
        if root is None:
            return 0
        l = max(0, self.helper(root.left))
        r = max(0, self.helper(root.right))
        s = l + r + root.val
        self.ans = max(self.ans, s)
        return max(l, r) + root.val

class Solution_(object):
    maxSum = float("-inf")

    # @param root, a tree node
    # @return an integer
    def maxPathSum(self, root):
        self.maxPathSumRecu(root)
        return self.maxSum

    def maxPathSumRecu(self, root):
        if root is None:
            return 0
        left = max(0, self.maxPathSumRecu(root.left))
        right = max(0, self.maxPathSumRecu(root.right))
        self.maxSum = max(self.maxSum, root.val + left + right)
        return root.val + max(left, right)

def main():
    s = Solution()
    r = TreeNode(-6)
    a = TreeNode(2)
    b = TreeNode(3)
    c = TreeNode(4)
    r.left = a
    r.right = b
    a.right = c
    print(s.maxPathSum(r))
main()

