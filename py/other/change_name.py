##
'''
A small script written by Xuqiang Fang on 4 Sep, 2018 to change file names 
'''
'''
path = '/Users/xuqiang/Desktop/order.txt'
file = open(path, 'r')
i = 0
ans = []
for line in file:
    i += 1
    ans.append(line[:-1] + '_' + str(i) + '\n')
print(ans)
with open("/Users/xuqiang/Desktop/save.txt", 'w') as f:
    for it in ans:
        f.write(it)
file.close()
'''

import os
path = '/Users/xuqiang/Desktop/lecture/Scala'
order = '/Users/xuqiang/Desktop/order.txt'
files = open(order, 'r')
num = [0]
for f in files:
    i = f.index('_')
    num.append(int(f[i+1:]))
files.close()
i = 0
files = os.listdir(path)
files.sort()
print(len(files))
print(len(num))

'''
for f in files:
    if f == '.DS_Store':
        continue
    print(f)
    j = f.index('_')
    os.rename(os.path.join(path, f), os.path.join(path, f[j+1:]))
'''
names = [0]
for f in files:
    if i == 0:
        i += 1
        continue
    #os.rename(os.path.join(path, f), os.path.join(path, str(num[i])+'_' + f))
    #print(f, num[i])
    names.append(str(num[i])+'_'+f)
    i += 1
print(names)
i = 0
for f in files:
    if i == 0:
        i += 1
        continue
    os.rename(os.path.join(path, f), os.path.join(path, names[i]))
    i += 1


