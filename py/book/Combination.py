def combination(l, c):#select c from l
    '''
    l is a list, we have to select c elements from l
    '''
    ans = []
    dfs(ans, l, c, [])
    return ans
def dfs(ans, l, c, t):
    if len(t) == c:
        ans.append(t[:])
        return
    for j in range(len(l)):
        if j not in t:
            t.append(j)
            dfs(ans, l, c, t)
            t.remove(j)

l = [1,2,3,4,5]
#print(combination(l, 2))

class Solution(object):
    def removeInvalidParentheses(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        # Calculate the minimum left and right parantheses to remove
        def findMinRemove(s):
            left_removed, right_removed = 0, 0
            for c in s:
                if c == '(':
                    left_removed += 1
                elif c == ')':
                    if not left_removed:
                        right_removed += 1
                    else:
                        left_removed -= 1
            return (left_removed, right_removed)

        # Check whether s is valid or not.
        def isValid(s):
            sum = 0
            for c in s:
                if c == '(':
                    sum += 1
                elif c == ')':
                    sum -= 1
                if sum < 0:
                    return False
            return sum == 0

        def removeInvalidParenthesesHelper(start, left_removed, right_removed):
            if left_removed == 0 and right_removed == 0:
                tmp = ""
                for i, c in enumerate(s):
                    if i not in removed:
                        tmp += c
                if isValid(tmp):
                    res.append(tmp)
                return

            for i in xrange(start, len(s)):
                if right_removed == 0 and left_removed > 0 and s[i] == '(':
                    if i == start or s[i] != s[i - 1]:  # Skip duplicated.
                        removed[i] = True
                        removeInvalidParenthesesHelper(i + 1, left_removed - 1, right_removed)
                        del removed[i]
                elif right_removed > 0 and s[i] == ')':
                    if i == start or s[i] != s[i - 1]:  # Skip duplicated.
                        removed[i] = True
                        removeInvalidParenthesesHelper(i + 1, left_removed, right_removed - 1);
                        del removed[i]

        res, removed = [], {}
        (left_removed, right_removed) = findMinRemove(s)
        removeInvalidParenthesesHelper(0, left_removed, right_removed)
        return res

'''
print(Solution().removeInvalidParentheses(')()()()((((()))()('))
print(Solution().removeInvalidParentheses('(((()))()'))
print(Solution().removeInvalidParentheses('(())()(())(((((()))))'))
print(len(Solution().removeInvalidParentheses('((((()()(fdsfas90()))((((((())))))))))(fsdafs()))()()afdsafsfs)')))
'''
print(Solution().removeInvalidParentheses('((((()()(fdsfas90()))((((((())))))))))(fsdafs()))()()afdsafsfs)'))
