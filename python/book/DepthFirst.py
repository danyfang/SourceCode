
L = [1,[2,[3,4],5],6,[7,8]]
# this is recursion
def recursive(L):
    total = 0
    for x in L:
        if not isinstance(x, list):
            total += x
            print(x)
        else:
            total += recursive(x)
    return total
print("Perform recursion :")
total = recursive(L)
print(total)

#this is depth first
def depthFirst(L):
    total = 0
    items = list(L)
    while items:
        front = items.pop(0)
        #print(front)
        if not isinstance(front, list):
            print(front)
            total += front
        else:
            items[:0] = front
    return total
print("Perform depth first search : ")
total = depthFirst(L)
print(total)

