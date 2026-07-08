class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        ArrayList<String> reversedList = new ArrayList<>();
        
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                reversedList.add(words[i]);
            }
        }
        
        return String.join(" ", reversedList);
    }
}