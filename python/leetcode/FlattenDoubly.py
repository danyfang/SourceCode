'''
Leetcode problem No 430 Flatten a Multilevel Doubly Linked List
Solution written by Xuqiang Fang on 13 July, 2018
'''
class Node(object):
    def __init__(self, val, prev, next, child):
        self.val = val
        self.prev = prev
        self.next = next
        self.child = child

class Solution(object):
    def flatten(self, head):
        """
        :type head: Node
        :rtype: Node
        """
        if not head:
            return head
        curr = head
        while curr:
            if curr.child:
                keep = curr.next
                sub = self.flatten(curr.child)
                curr.next = sub
                sub.prev = curr
                while sub.next:
                    sub = sub.next
                sub.next = keep
                if keep:
                    keep.prev = sub
                curr.child = None
            curr = curr.next
        return head

def main():
    s = Solution()
    a = Node(1, None, None, None)
    b = Node(2, a, None, None)
    c = Node(3, b, None, None)
    d = Node(4, c, None, None)
    e = Node(5, d, None, None)
    f = Node(6, e, None, None)
    g = Node(7, b, None, None)
    h = Node(8, g, None, None)
    i = Node(9, h, None, None)
    j = Node(10, i, None, None)
    k = Node(11, h, None, None)
    l = Node(12, k, None, None)
    a.next = b
    b.next = c
    c.next = d
    d.next = e
    e.next = f
    g.next = h
    h.next = i
    i.next = j
    k.next = l
    c.child = g
    h.child = k
    head = s.flatten(a)
    print('here')
    while head:
        print(head.val)
        head = head.next

if __name__ == '__main__':
    main()
