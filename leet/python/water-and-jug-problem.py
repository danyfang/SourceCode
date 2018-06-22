# Time:  O(logn),  n is the max of (x, y)
# Space: O(1)

# You are given two jugs with capacities x and y litres.
# There is an infinite amount of water supply available.
# You need to determine whether it is possible to
# measure exactly z litres using these two jugs.
#
# Operations allowed:
#
# Fill any of the jugs completely.
# Empty any of the jugs.
# Pour water from one jug into another till
# the other jug is completely full or
# the first jug itself is empty.
# Example 1:
#
# Input: x = 2, y = 6, z = 4
# Output: True
# Example 2:
#
# Input: x = 2, y = 6, z = 5
# Output: False

# Bézout's identity (also called Bézout's lemma)
class Solution(object):
    def canMeasureWater(self, x, y, z):
        """
        :type x: int
        :type y: int
        :type z: int
        :rtype: bool
        """
        def gcd(a, b):
            while b:
                a, b = b, a%b
            return a

        # The problem is to solve:
        # - check z <= x + y
        # - check if there is any (a, b) integers s.t. ax + by = z
        return z == 0 or ((z <= x + y) and (z % gcd(x, y) == 0))
