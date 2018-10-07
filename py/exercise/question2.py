def factorial(num):
    res = 1
    for i in range(1, num+1):
        res *= i

    return res

while True:
    x = raw_input('Please input a numebr: ')
    if x.__eq__('q'): break
    print(factorial(int(x)))
