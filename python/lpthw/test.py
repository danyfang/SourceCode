#!/usr/bin/python

from __future__ import division
#lambda function to calculate factor
x = int(raw_input("Please input an integer\n > "))
print reduce(lambda x,y: x*y, range(1,x+1))


def add(x,y):
	return x+y

def sub(x,y):
	return x-y

def mul(x,y):
	return x*y

def div(x,y):
	return x/y

operator = {"+":add, "-":sub, "*":mul, "/":div}
if __name__ == "__main__":
	x = raw_input("Please input a numebr\n > ")
	o = raw_input("Please input an operator\n > ")
	y = raw_input("Please input a numebr\n > ")

	print operator.get(o)(int(x), int(y))

