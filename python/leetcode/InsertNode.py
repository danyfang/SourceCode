'''
Leetcode problem No 708 Insert into a Cyclic Sorted List
Solution written by Xuqiang Fang on 12 July, 2018
'''
class Node(object):
    def __init__(self, val, next):
        self.val = val
        self.next = next

class Solution(object):
    def insert(self, head, insertVal):
        """
        :type head: Node
        :type insertVal: int
        :rtype: Node
        """
        if not head:
            n = Node(insertVal, None)
            n.next = n
            return n
        curr = head
        gap = None
        while True:
            if curr.val <= insertVal and curr.next.val >= insertVal:
                n = Node(insertVal, curr.next)
                curr.next = n
                return head
            if curr.val > curr.next.val:
                gap = curr
            curr = curr.next
            if curr == head:
                break
        n = Node(insertVal, gap.next)
        gap.next = n
        return head

def print_node(head):
    curr = head
    while curr.next != head:
        print(curr.val)
        curr = curr.next
    print(curr.val)

def main():
    s = Solution()
    a = Node(1, None)
    b = Node(4, a)
    c = Node(3, b)
    a.next = c
    #print_node(c)
    s.insert(a, 5)
    print_node(c)

if __name__ == '__main__':
    main()


