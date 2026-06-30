class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        res, last = 0, [-1] * 3
        for i, c in enumerate(s):
            last[ord(c) - 97] = i
            res += min(last) + 1
        return res