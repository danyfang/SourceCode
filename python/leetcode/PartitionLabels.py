'''
Leetcode problem No 763 Partition Labels
Solution written by Xuqiang Fang on 18 July, 2018
'''

class Solution:
    def partitionLabels(self, S):
        """
        :type S: str
        :rtype: List[int]
        """
        index = {}
        for i in range(len(S)):
            if S[i] not in index:
                index[S[i]] = i
            else:
                index[S[i]] = i
        print(index)
        curr = 0; prev = 0
        ans = []
        for i in range(len(S)):
            s = S[i]
            #print(curr)
            if index[s] == curr and i == curr:
                #print(s, i)
                ans.append(i-prev+1)
                prev = i+1
                curr = prev
            else:
                curr = max(curr, index[s])
        if prev < len(S):
            ans.append(len(S)-prev)
        return ans
                    

def main():
    s = Solution()
    S = "ababcbacadefegdehijhklij"
    print(s.partitionLabels(S))
    S = "eaaaabaaec"
    print(s.partitionLabels(S))
    S = "vhaagbqkaq"
    print(s.partitionLabels(S))

if __name__ == '__main__':
    main()
