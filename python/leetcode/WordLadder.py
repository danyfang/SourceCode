'''
Leetcode problem No 127 Word Ladder
Solution written by Xuqiang Fang on 22 May, 2018 
'''

class Solution:
     
    def ladderLength(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: int
        """
        d = set(wordList)
        if not endWord in d:
            return 0
        begin = set()
        end = set()
        change = list('abcdefghijklmnopqrstuvwxyz')
        begin.add(beginWord)
        end.add(endWord)

        step = 0
        while len(begin) > 0 and len(end) > 0:
            step += 1
            if len(begin) > len(end):
                begin, end =  end, begin
            tmp = set()
            for word in begin:
                for i in range(len(word)):
                    c = word[i]
                    for j in change:
                        n = word[:i] + j + word[i+1:]
                        if n in end:
                            step += 1
                            return step
                        elif not n in d:
                            continue
                        d.remove(n)
                        tmp.add(n)
            begin, tmp = tmp, begin

        return 0

    #TLE
    def findLadders(self, beginWord, endWord, wordList):
        """
        :type beginWord: str
        :type endWord: str
        :type wordList: List[str]
        :rtype: List[List[str]]
        """
        res = [[]]
        if not endWord in wordList:
            return []
        if not beginWord in wordList:
            wordList = [beginWord] + wordList
        graph = [[] for i in wordList]
        for i in range(len(wordList)):
            for j in range(i+1, len(wordList)):
                if self.neighbor(wordList[i], wordList[j]): 
                    graph[i].append(j)
                    graph[j].append(i)
        endIndex = wordList.index(endWord)
        if len(graph[endIndex]) == 0:
            return []
        #print(graph)
        temp = [beginWord]
        visited = {wordList.index(beginWord)}
        self.dfs(res, graph, wordList, endWord, temp, visited, wordList.index(beginWord))
        return res 

    shortest = 10 ** 9 
    def dfs(self, res, graph, word, end, temp, visited, index):
        if temp[-1] == end:
            if len(temp) < self.shortest:
                res.clear()
                self.shortest = len(temp)
                res.append(list(temp))
            elif len(temp) == self.shortest:
                res.append(list(temp))
            return
        n = graph[index]
        for i in n:
            if i in visited:
                continue
            visited.add(i)
            temp.append(word[i])
            self.dfs(res, graph, word, end, temp, visited, i)
            temp.pop(-1)
            visited.remove(i)
        
    def neighbor(self, a, b):
        count = 0
        for i in range(len(a)):
            if a[i] != b[i]:
                count += 1
        return count == 1


def main():
    s = Solution()
    begin = "hit"
    end = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]
    word = ["hot","dot","dog","lot","log"]
    print(s.ladderLength(begin, end, wordList))
    print(s.ladderLength(begin, end, word))
    print(s.findLadders(begin, end, wordList))

main()
