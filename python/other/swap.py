#!/usr/bin/python

def swap(a, b):
    a = a + b
    b = a - b
    a = a - b
    return a,b

a = 1
b = 2
a,b = swap(a,b)
print a,b
