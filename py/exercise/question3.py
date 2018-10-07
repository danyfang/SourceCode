
def construct(n):
    res = {}
    for i in range(1,n+1):
        res[i] = i * i

    return res

while True:
    x = raw_input("Input a number ")
    if x.__eq__('q'): break
    print(construct(int(x)))
