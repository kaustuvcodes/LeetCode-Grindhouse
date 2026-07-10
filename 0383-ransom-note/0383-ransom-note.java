class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            int count1 = 0;
            int count2 = 0;
            for (int j = 0; j < ransomNote.length(); j++) {
                if (ransomNote.charAt(j) == ch) {
                    count1++;
                }
            }
            for (int j = 0; j < magazine.length(); j++) {
                if (magazine.charAt(j) == ch) {
                    count2++;
                }
            }
            if (count1 > count2) {
                return false;
            }
        }
        return true;
    }
}