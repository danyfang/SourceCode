import math
input = raw_input().split(',')
output = []

for num in input:
    temp = math.sqrt(2 * 50 * int(num) / 30)
    output.append(str(int(temp)))

print(','.join(output))
