'''
Leetcode problem No 393 UTF-8 Validation
Solution written by Xuqiang Fang on 1 Aug, 2018
'''

class Solution(object):
    def validUtf8(self, data):
        """
        :type data: List[int]
        :rtype: bool
        """
        n = len(data); i= 0
        while i < n:
            s = bin(data[i])[2:].zfill(8)[-8:]
            if s[0] == '0':
                i += 1
            elif s[0] == '1':
                j = 0
                while j < 8 and s[j] == '1':
                    j += 1
                if i+j > n or j == 1 or j > 4:
                    return False
                for x in range(1, j):
                    t = bin(data[i+x])[2:].zfill(8)[-8:]
                    if t[0:2] != '10':
                        return False
                i += j

        return True

def main():
    s = Solution()
    data = [197, 130, 1] #true
    print(s.validUtf8(data))
    data = [235, 140, 4] #false
    print(s.validUtf8(data))
    data = [255]#false
    print(s.validUtf8(data))
    data = [240,162,138,147,17, 197, 130, 1]#true
    print(s.validUtf8(data))
    data = [250,145,145,145,145]#false
    #print([bin(x)[-8:] for x in data])
    print(s.validUtf8(data))
    data = [1115,100,102,231,154,132,13,10]
    print([bin(x)[2:].zfill(8)[-8:] for x in data])
    print(s.validUtf8(data))

if __name__ == '__main__':
    main()
