'''
Leetcode problem No 866 Smallest Subtree with all the Deepest Nodes
Solution written by Xuqiang Fang on 8 July, 2018
'''
import collections
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        def height(root):
            if not root:
                return 0
            return 1 + max(height(root.left), height(root.right))
        ### for this problem, we don't need to serialize the tree ourselves
        ### and define another function as a member of class can accelerate the program
        def serialize(root):
            ans = []
            if not root:
                return ans
            q = collections.deque([root])
            ans.append(root)
            while q:
                curr = q.popleft()
                if curr.left:
                    q.append(curr.left)
                    ans.append(curr.left)
                else:
                    ans.append(None)
                if curr.right:
                    q.append(curr.right)
                    ans.append(curr.right)
                else:
                    ans.append(None)
            while not ans[-1]:
                ans.pop()
            return ans
        if not root:
            return root
        h = height(root)
        l = height(root.left)
        r = height(root.right)
        if l == h-1 and r == h-1:
            return root
        elif l > r:
            return self.subtreeWithAllDeepest(root.left)
        return self.subtreeWithAllDeepest(root.right)

    def serialize(self, root):
        ans = []
        if not root:
            return ans
        q = collections.deque([root])
        ans.append(root)
        while q:
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
                ans.append(curr.left)
            else:
                ans.append(None)
            if curr.right:
                q.append(curr.right)
                ans.append(curr.right)
            else:
                ans.append(None)
        while not ans[-1]:
            ans.pop()
        return ans

    def height(self, root):
        if not root:
            return 0
        return 1 + max(self.height(root.left), self.height(root.right))

class Solution2(object):
    def subtreeWithAllDeepest(self, root):
        """
        :type root: TreeNode
        :rtype: TreeNode
        """
        if not root:
            return root
        h = self.height(root)
        l = self.height(root.left)
        r = self.height(root.right)
        if l == h-1 and r == h-1:
            return self.serializ(root)
        elif l > r:
            return self.subtreeWithAllDeepest(root.left)
        return self.subtreeWithAllDeepest(root.right)

    def serializ(self, root):
        ans = []
        if not root:
            return ans
        q = collections.deque([root])
        ans.append(root)
        while q:
            curr = q.popleft()
            if curr.left:
                q.append(curr.left)
                ans.append(curr.left)
            else:
                ans.append(None)
            if curr.right:
                q.append(curr.right)
                ans.append(curr.right)
            else:
                ans.append(None)
        while not ans[-1]:
            ans.pop()
        return ans

    def height(self, root):
        if not root:
            return 0
        return 1 + max(self.height(root.left), self.height(root.right))

def main():
    s = Solution()
    s2 = Solution2()
    r = TreeNode(3)
    a = TreeNode(5)
    b = TreeNode(1)
    c = TreeNode(6)
    d = TreeNode(2)
    e = TreeNode(0)
    f = TreeNode(8)
    g = TreeNode(7)
    h = TreeNode(4)
    r.left = a
    r.right = b
    a.left = c
    a.right = d
    b.left = e
    b.right = f
    d.left = g
    d.right = h
    ans = s.subtreeWithAllDeepest(r)
    print(len(ans))
    ans = s2.subtreeWithAllDeepest(r)
    print(len(ans))
    for t in ans:
        if t:
            print(t.val)
    ans = s.serialize(r)
    print('length of serialization is : %d'%len(ans))
    for t in ans:
        if t:
            print(t.val)
        else:
            print(t)
main()
