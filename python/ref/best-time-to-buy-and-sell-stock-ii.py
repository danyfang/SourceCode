# Time:  O(n)
# Space: O(1)
#
# Say you have an array for which the ith element is
# the price of a given stock on day i.
#
# Design an algorithm to find the maximum profit.
# You may complete as many transactions as you like
# (ie, buy one and sell one share of the stock multiple times).
# However, you may not engage in multiple transactions at the same time
# (ie, you must sell the stock before you buy again).

try:
    xrange          # Python 2
except NameError:
    xrange = range  # Python 3


class Solution:
    # @param prices, a list of integer
    # @return an integer
    def maxProfit(self, prices):
        profit = 0
        for i in xrange(len(prices) - 1):
            profit += max(0, prices[i + 1] - prices[i])
        return profit

    def maxProfit2(self, prices):
        return sum(map(lambda x: max(prices[x + 1] - prices[x], 0),
                       xrange(len(prices[:-1]))))