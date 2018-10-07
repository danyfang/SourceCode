
def scramble(seq):
    for i in range(len(seq)):
        seq = seq[1:] + seq[:1]
        yield seq

l = list(scramble('spam'))
print(l)

def scramble2(seq):
    for i in range(len(seq)):
        yield seq[i:] + seq[:i]

l = list(scramble2('spam'))
print(l)
