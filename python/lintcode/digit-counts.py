#No. 3 Digit Counts
'''
Description : Count the number of k's between 0 and n. k can be 0 - 9.
'''
class Solution:
    """
    @param: : An integer
    @param: : An integer
    @return: An integer denote the count of digit k in 1..n
    """
    def digitCounts(self, k, n):
        # write your code here
        ans, m = 0, 1
        while m <= n:
            ans += (n//m + (9-k) % 9) // 10 * m + (n//m % 10 == k) * (n%m + 1)
            m *= 10
        if k == 0:
            ans += 1
        return ans

def main():
    s = Solution()
    print(s.digitCounts(0,342))
    print(s.digitCounts(1,342))
    print(s.digitCounts(2,342))
    print(s.digitCounts(3,342))

if __name__ == '__main__':
    main()
