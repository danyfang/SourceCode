'''
Leetcode problem No 468 Validate IP Address
Solution written by Xuqiang Fang on 15 July, 2018
'''

class Solution(object):
    def validIPAddress(self, IP):
        """
        :type IP: str
        :rtype: str
        """
        s = set(list(IP))
        if '.' in s:
            if self.check4(IP):
                return 'IPv4'
        else:
            if self.check6(IP):
                return 'IPv6'
        return 'Neither'
        
    def check4(self, IP):
        ip = IP.split('.')
        if len(ip) != 4:
            return False
        for i in ip:
            for j in i:
                if not j.isdigit():
                    return False
            if len(i) == 0:
                return False
            elif len(i) > 1 and i[0] == '0':
                return False
            elif int(i) > 255 or int(i) < 0:
                return False
        return True

    def check6(self, IP):
        ip = IP.split(':')
        if len(ip) != 8:
            return False
        for i in ip:
            if len(i) == 0:
                return False
            elif len(i) > 4:
                return False
            for j in i:
                if not j.isdigit():
                    j = j.upper()
                    if ord(j) > ord('F') or ord(j) < ord('A'):
                        return False
        return True

def main():
    s = Solution()
    print(s.validIPAddress("172.16.254.1"))
    print(s.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334"))
    print(s.validIPAddress("256.256.256.256"))
    print(s.validIPAddress("1081:db8:85a3:01:-0:8A2E:0370:7334"))
if __name__ == '__main__':
    main()
