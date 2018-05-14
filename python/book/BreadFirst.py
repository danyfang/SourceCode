
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


#this is bread first
def breadFirst(L):
    total = 0
    items = list(L)
    while items:
        front = items.pop(0)
        if not isinstance(front, list):
            print(front)
            total += front
        else:
            items.extend(front)
    return total

print("Perform bread first search :")
total = breadFirst(L)
print(total)

