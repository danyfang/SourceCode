'''
Leetcode problem No 824 Most Profit Assigning Work
Solution written by Xuqiang Fang on 11 June, 2018
'''

class Solution(object):
    def maxProfitAssignment(self, difficulty, profit, worker):
        """
        :type difficulty: List[int]
        :type profit: List[int]
        :type worker: List[int]
        :rtype: int
        """ 
        l = [[difficulty[i],profit[i]] for i in range(len(difficulty))]
        l.sort()
        print(l)
        worker.sort()
        s = 0; i = 0; j = 0; m = 0
        while(i < len(worker)):
            while(j < len(l) and l[j][0] <= worker[i]):
                m = max(m, l[j][1])
                j += 1
            print(m)
            s += m
            i += 1
        return s


def main():
    s = Solution()
    diff = [2,4,6,8,10]
    profit = [10,20,30,40,50]
    worker = [4,5,6,7]
    print(s.maxProfitAssignment(diff, profit, worker))

main()
        
