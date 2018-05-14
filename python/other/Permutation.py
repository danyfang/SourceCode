
def permutation(N):
    dfs(N, [])

count = 0
def dfs(N, l):
    if len(l) == N : 
        global count 
        count += 1
        print(l)
    for i in range(1,N+1):
        if not i in l:
            l.append(i)
            dfs(N,l)
            l.pop(len(l)-1)

permutation(4)
print('total %d lists'%(count))
