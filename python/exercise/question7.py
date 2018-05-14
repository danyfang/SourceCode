
def construct(a, b):
    res = []
    for row in range(a):
        l = []
        for col in range(b):
            l.append(row * col)
        res.append(l)
    return res
input_str = raw_input()
dimension = [int(x) for x in input_str.split(',')]
print(construct(dimension[0],dimension[1]))
