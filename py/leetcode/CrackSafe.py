'''
Leetcode problem No 753 Cracking the Safe
Solution written by Xuqiang Fang on 5 July, 2018
'''

class Solution(object):
    def crackSafe(self, n, k):
        """
        :type n: int
        :type k: int
        :rtype: str
        """
        N = pow(k, n)
        ans = [0 for i in range(n)]
        visited = set()
        visited.add(tuple(ans))
        self.dfs(ans, visited, n, k, N)
        return ''.join([str(i) for i in ans]) 

    def dfs(self, ans, v, n, k, N):
        if len(v) == N:
            return True
        for i in range(k):
            ans.append(i)
            t = tuple(ans[-n:])
            if t not in v:
                v.add(t)
                if self.dfs(ans, v, n, k, N):
                    return True
                v.remove(t)
            ans.pop()
        return False

def main():
    s = Solution()
    print(s.crackSafe(3,8))
main()
