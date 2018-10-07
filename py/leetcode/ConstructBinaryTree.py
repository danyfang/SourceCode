'''
Leetcode problem No 889 Construct Binary Tree from Preorder and Postorder Traversal
Solution written by Xuqiang Fang on 19 Aug, 2018
'''
import collections
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
class Solution(object):
    def constructFromPrePost(self, pre, post):
        """
        :type pre: List[int]
        :type post: List[int]
        :rtype: TreeNode
        """
        n = len(pre)
        if n == 1:
            return TreeNode(pre[0])
        root = TreeNode(pre[0])
        left = 1; right = 0
        s_left = set(); s_right = set()
        s_left.add(pre[left])
        s_right.add(post[right])
        while s_left != s_right and left < n:
            left += 1
            right += 1
            s_left.add(pre[left])
            s_right.add(post[right])
        root.left = self.constructFromPrePost(pre[1:left+1], post[:right+1])
        root.right = self.constructFromPrePost(pre[left+1:], post[right+1:])
        return root

def traveral(root):
    q = collections.deque([root])
    while q:
        p = q.popleft()
        if p:
            print(p.val)
            q.append(p.left)
            q.append(p.right)

def main():
    s = Solution()
    pre = [1,2,4,5,3,6,7] 
    post = [4,5,2,6,7,3,1]
    traveral(s.constructFromPrePost(pre, post))


if __name__ == '__main__':
    main()
