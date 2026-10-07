class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') l++;
            else if (c == ')') {
                if (l > 0) l--;
                else r++;
            }
        }
        backtrack(s, 0, l, r, res);
        return res;
    }

    private void backtrack(String s, int start, int l, int r, List<String> res) {
        if (l == 0 && r == 0) {
            if (isValid(s)) res.add(s);
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (i > start && s.charAt(i) == s.charAt(i - 1)) continue;
            if (s.charAt(i) == '(' && l > 0) {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, l - 1, r, res);
            }
            if (s.charAt(i) == ')' && r > 0) {
                backtrack(s.substring(0, i) + s.substring(i + 1), i, l, r - 1, res);
            }
        }
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}