class Solution {
    public String[] findWords(String[] words) {
        String row1= "qwertyuiop";
        String row2="asdfghjkl";
        String row3 ="zxcvbnm";
        ArrayList<String> ans = new ArrayList<>();
        for(int i =0;i<words.length;i++){
            String word = words[i].toLowerCase();
            int count1 =0;
            int count2 =0;
            int count3 =0;
            for(int j =0;j<word.length();j++){
                char ch = word.charAt(j);
                if(row1.indexOf(ch)!=-1){
                    count1++;
                }
                if(row2.indexOf(ch)!=-1){
                    count2++;

                }
                if(row3.indexOf(ch)!= -1){
                    count3++;
                }

            }
            if(count1 == word.length() || count2 == word.length() || count3 == word.length()){
                ans.add(words[i]);
            }

        }
        return ans.toArray(new String[0]);

    }
}