class Solution {

    public int countvowel(String s) {
        s = s.toLowerCase();

        int count = 0;

        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                count++;
        }

        return count;
    }

    public boolean halvesAreAlike(String s) {

        int n = s.length();

        int a = countvowel(s.substring(0, n / 2));

        int b = countvowel(s.substring(n / 2));

        return a == b;
    }
}