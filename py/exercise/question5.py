
class stringInOut(object):
    def __init__(self):
        self.x = ''

    def input(self):
        self.x = raw_input()

    def output(self):
        print(self.x.upper())

s = stringInOut()
s.input()
s.output()
s.input()
s.input()
s.output()
