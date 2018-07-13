'''
Leetcode problem No 691 Stickers to Spell Word
Solution written by Xuqiang Fang on 6 July, 2018
'''
import collections
class Solution(object):
    def minStickers(self, stickers, target):
        """
        :type stickers: List[str]
        :type target: str
        :rtype: int
        """
        def dfs(count, target, dp):
            #print(target)
            if target in dp:
                return dp[target]
            tar = collections.Counter(target)
            ans = float('inf')
            for c in count:
                #print(c)
                if c[target[0]] == 0:
                    continue
                nex = []
                for k in tar.keys():
                    if tar[k] > c[k]:
                        nex.extend([k] * (tar[k]-c[k]))
                #print(nex)
                if len(nex) != len(target):
                    num = dfs(count, ''.join(nex), dp)
                    if num != -1:
                        ans = min(ans, 1 + num)
            dp[target] = -1 if ans == float('inf') else ans
            return dp[target]

        count = [collections.Counter(s) for s in stickers]
        dp = {"":0}
        #print(collections.Counter(target))
        return dfs(count, target, dp)
    
    ####### the following only gives correct result in python2
    '''
    the only difference between the first program and the second program is the usage of map
        sticker_counts = map(collections.Counter, stickers) #python2
        count = [collections.Counter(s) for s in stickers] #python3
        so in python 3, map does not generate a list of iterables 
    '''
    def minStickers_(self, stickers, target):
        """
        :type stickers: List[str]
        :type target: str
        :rtype: int
        """
        def minStickersHelper(sticker_counts, target, dp):
            if "".join(target) in dp:
                return dp["".join(target)]
            target_count = collections.Counter(target)
            result = float("inf")
            for sticker_count in sticker_counts:
                if sticker_count[target[0]] == 0:
                    continue
                new_target = []
                for k in target_count.keys():
                    if target_count[k] > sticker_count[k]:
                       new_target += [k]*(target_count[k] - sticker_count[k])
                if len(new_target) != len(target):
                    num = minStickersHelper(sticker_counts, new_target, dp)
                    if num != -1:
                        result = min(result, 1+num)
            dp["".join(target)] = -1 if result == float("inf") else result
            return dp["".join(target)]

        sticker_counts = map(collections.Counter, stickers)
        print(sticker_counts)
        dp = { "":0 }
        return minStickersHelper(sticker_counts, target, dp)

def main():
    s = Solution()
    stickers = ["with", "example", "science"]
    target = "thehat"
    print(s.minStickers(stickers, target))
    stickers = ["notice", "possible"]
    target = "basicbasic"
    print(s.minStickers(stickers, target))
    #print(s.minStickers_(stickers, target))
main()
