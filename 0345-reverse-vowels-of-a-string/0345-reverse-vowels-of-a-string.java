class Solution {
    public String reverseVowels(String s) {
        char[] kaustuv = s.toCharArray();
        int i = 0, j = kaustuv.length - 1;

        while (i < j) {
            if (!vowel(kaustuv[i])) {
                i++;
            } else if (!vowel(kaustuv[j])) {
                j--;
            } else {
                char temp = kaustuv[i];
                kaustuv[i] = kaustuv[j];
                kaustuv[j] = temp;
                i++;
                j--;
            }
        }

        return new String(kaustuv);
    }

    public boolean vowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}