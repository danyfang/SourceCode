'''
Leetcode problem No 388 Longest Absolute File Path
Solution written by Xuqiang Fang on 20 June, 2018
'''

class Solution(object):
    def lengthLongestPath(self, path):
        stack = [0]
        ans = 0
        for s in path.split('\n'):
            lev = -1
            # to find if there is another way to find the last index of '\t'
            # here is the naive method
            for i in range(len(s)):
                if s[i] == '\t':
                    lev = i
            lev += 1
            #print('lev = %d'%lev)
            while lev+1 < len(stack):
                stack.pop(-1)
            #print(len(stack))
            l = stack[-1] + len(s) - lev + 1
            stack.append(l)
            if s.find('.') != -1:
                ans = max(ans, l-1)
        return ans 

def main():
    s = Solution()
    path  ='dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext'
    pat = 'dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext'
    print(s.lengthLongestPath(path))
    print(s.lengthLongestPath(pat))
main()
