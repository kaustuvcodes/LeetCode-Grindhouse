class Solution {
    public int maxDepth(String s) {
        int max = 0, open = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                open++;
                max = Math.max(open, max);
            }
            else if (ch == ')') {
                open--;
            }
        }

        return max;
    }
}