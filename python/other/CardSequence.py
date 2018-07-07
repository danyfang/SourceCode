import collections
class CardSequence:
    def card(self, n):
        if n == 1:
            return [1]
        d = collections.deque([1])
        i = 2
        while i <= n+1:
            t = d.pop()
            d.appendleft(t)
            d.appendleft(i)
            i += 1
        return d

s = CardSequence()
print(s.card(3))
print(s.card(4))
print(s.card(5))
