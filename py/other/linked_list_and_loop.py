class Node(object):
    def __init__(self, data=None, next_node=None):
        self.data = data
        self.next = next_node

    def increment(self):
        self.data += 1
        return self.data

    def setNext(self, next_node=None):
        self.next = next_node


def create_chain(number, loop):
    if number <= 0 or loop > number:
        print("Error")
        return
    nodes = [Node(i) for i in range(number)]
    for i in range(number-1):
        nodes[i].setNext(nodes[i+1])
    if loop > 0:
        nodes[number-1].setNext(nodes[number-loop])
    return nodes[0]
        

def loop_size(node):
    def helper(node):
        #print(node.data)
        count = 1
        temp = node
        while(temp.next != node):
            temp = temp.next
            count += 1
        return count
    
    if not node:
        return 0
    
    slow = fast = node
    while(slow and fast and fast.next):
        slow = slow.next
        fast = fast.next.next
        if slow == fast:
            return helper(slow)
    return 0


chain = create_chain(300, 300)
print(loop_size(chain))


