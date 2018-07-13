'''
Leetcode problem No 652 Find Duplicate Subtrees
Solution written by Xuqiang Fang on 13 July, 2018
'''

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

class Solution(object):
    def findDuplicateSubtrees(self, root):
        """
        :type root: TreeNode
        :rtype: List[TreeNode]
        """
        counts = {}
        ans = []
        self.serialize(root, counts, ans)
        return ans

    def serialize(self, root, counts, ans):
        if not root:
            return '#'
        key = str(root.val) + ',' + self.serialize(root.left, counts, ans) \
            + ',' + self.serialize(root.right, counts, ans)
        if key not in counts:
            counts[key] = 0
        counts[key] += 1
        if counts[key] == 2:
            print('here')
            ans.append(root)
        return key

    def findDuplicateSubtrees_(self, root):
        ##second method
        ids = {}; counts = {}
        ans = []
        self.get(root, ids, counts, ans)
        return ans

    def get(self, root, ids, counts, ans):
        if not root:
            return 0
        key = (root.val << 32) | (self.get(root.left, ids, counts, ans) << 16) \
            | (self.get(root.right, ids, counts, ans))
        if key not in ids:
            ids[key] = len(ids) + 1
        k = ids[key]
        if k not in counts:
            counts[k] = 0
        counts[k] += 1
        if counts[k] == 2:
            ans.append(root)
        return k

def print_tree(root):
    if root:
        print_tree(root.left)
        print_tree(root.right)
        print(root.val)

def main():
    s = Solution()
    r = TreeNode(1)
    a = TreeNode(2)
    b = TreeNode(3)
    c = TreeNode(4)
    d = TreeNode(2)
    e = TreeNode(4)
    f = TreeNode(4)
    r.left = a
    r.right = b
    a.left = c
    b.left = d
    b.right = e
    d.left = f
    print_tree(a)
    ans = s.findDuplicateSubtrees_(r)
    print('length is %d'%len(ans))
    for i in ans:
        print_tree(i)

if __name__ == '__main__':
    main()
