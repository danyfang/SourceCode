'''
Leetcode problem No 857 Minimum Cost to Hire K Workers
Solution written by Xuqiang Fang on 24 June, 2018
'''
import heapq as heapq
class Solution(object):
    def mincostToHireWorkers(self, quality, wage, K):
        """
        :type quality: List[int]
        :type wage: List[int]
        :type K: int
        :rtype: float
        """
        work = sorted([float(w)/q, q] for w, q in zip(wage, quality))
        ans = float('inf')
        qsum = 0
        heap = []
        for r, q in work:
            heapq.heappush(heap, -q)
            qsum += q
            if len(heap) > K:
                qsum += heapq.heappop(heap)
            if len(heap) == K:
                ans = min(ans, qsum * r)
        return ans

def main():
    s = Solution()
    quality = [14,56,59,89,39,26,86,76,3,36]
    wage = [90,217,301,202,294,445,473,245,415,487]
    print(s.mincostToHireWorkers(quality, wage, 1))
    print(s.mincostToHireWorkers(quality, wage, 2))
    print(s.mincostToHireWorkers(quality, wage, 3))
    print(s.mincostToHireWorkers(quality, wage, 4))
    print(s.mincostToHireWorkers(quality, wage, 5))
main()
