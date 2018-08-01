import heapq as hp
class Solution:
    # @param k & A a integer and an array
    # @return ans a integer
    def kthLargestElement(self, k, A):
        ans = []
        for a in A:
            if len(ans) < k:
               hp.heappush(ans, a)
            elif len(ans) == k:
                if a > ans[0]:
                    hp.heappop(ans)
                    hp.heappush(ans, a)
        return ans[0]

def main():
    s = Solution()
    print(s.kthLargestElement(3, [9,3,2,4,8]))
    print(s.kthLargestElement(4, [9,3,2,4,8]))
    print(s.kthLargestElement(2, [9,3,2,4,8]))
main()
