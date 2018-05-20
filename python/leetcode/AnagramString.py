'''
Leetcode problem No 438 Find All Anagrams in a String
Solution written by Xuqiang Fang on 4 April, 2018 
'''

class Solution(object):
    def findAnagrams(self, s, p):
        n = len(p)
        list = []
        if(len(s) < n):
            return  list

        for i in range(len(s)-n+1):
            if(self.isAnagram(s[i:i+n], p)):
                list.append(i)
        return list

    def isAnagram(self, s, p):
        count = {"a":0, "b":0, "c":0,"d":0,"e":0,"f":0,"g":0,
                "h":0,"i":0,"j":0,"k":0,"l":0,"m":0,"n":0,"o":0,
                "p":0,"q":0,"r":0,"s":0,"t":0,"u":0,"v":0,"w":0,
                "x":0,"y":0,"z":0}
        for c in s:
            count[c] += 1
        for c in p:
            count[c] -= 1
        for i in count.values():
            if(i != 0):
                return False

        return True

def main():
    s = Solution()
    st = "cbaebabacd"
    p = "abc"
    print(s.findAnagrams(st, p))

main()
            

