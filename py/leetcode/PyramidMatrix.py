'''
Leetcode problem No 756 Pyramid Transition Matrix
Solution written by Xuqiang Fang on 19 May, 2018
'''

class Solution(object):
    def pyramidTransition(self, bottom, allowed):
        combination = {}
        for s in allowed:
            if not s[0:2] in combination:
                combination[s[0:2]] = []
            combination[s[0:2]].append(s[2])
        print(combination)
        return self.recursion(bottom, combination)

    def recursion(self, bottom, combination):
        if len(bottom) == 2:
            if bottom in combination:
                return True
            return False 

        for i in range(0, len(bottom)-1):
            key = bottom[i:i+2]
            if not key in combination:
                return False
        nextLevel = []
        self.dfs(bottom, nextLevel, combination, [], 0)
        #print("next level the bottom is :")
        #print(nextLevel)
        for key in nextLevel:
            if self.recursion(key, combination):
                return True

        return False

    def dfs(self, bottom, nextLevel, combination, temp, index):
        if len(temp) == len(bottom)-1:
            nextLevel.append("".join(temp))
            return
        for i in range(index, len(bottom)-1):
            keys = combination[bottom[index:index+2]]
            for key in keys:
                temp.append(key)
                self.dfs(bottom, nextLevel, combination, temp, i+1)
                temp.pop(len(temp)-1)

        

def main():
    s = Solution()
    bottom = 'XYZ'
    allowed = ['XYD','YZE','DEA','FFF', 'XYE']
    print(s.pyramidTransition(bottom, allowed))
main()

