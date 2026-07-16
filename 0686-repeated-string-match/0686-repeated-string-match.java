class Solution {
    public int repeatedStringMatch(String a, String b) {
        int n = a.length();
        int m = b.length();
        StringBuilder s = new StringBuilder();
        int count = 0;

        while (s.length() < m) {
            s.append(a);
            count++;
        }

        if (s.indexOf(b) != -1) {
            return count;
        }

        s.append(a);

        if (s.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }
}