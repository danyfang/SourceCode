#!/usr/bin/python

from sys import argv
script, filename = argv
print """
We're going to erase %r.
If you don't want that, hit CTRL-C (^C).
If you want that, hit RETURN.
""" %filename

raw_input("?")
print "Opening the file..."
target = open(filename, 'w')

print "Truncating the file. Goodbye!"
target.truncate()

print "Now I'm going to ask you fro three lines."
line1 = raw_input("line 1: ")
line2 = raw_input("line 2: ")
line3 = raw_input("line 3: ")

print "I'm going to write those to the file."

target.write(line1)
target.write("\n")
target.write(line2)
target.write("\n")
target.write(line3)
target.write("\n")
