class Solution {
    public int numOfStrings(String[] patterns, String word) {

        int kaustuv = 0;

        for (String pattern : patterns) {
            if (word.contains(pattern)) {
                kaustuv++;
            }
        }
        return kaustuv;
    }
}