class Solution {
    public String countAndSay(int n) {
        String val = "1";
        
        for (int i = 1; i < n; i++) {
            StringBuilder nextVal = new StringBuilder();
            int j = 0;
            
            while (j < val.length()) {
                int k = j;
                
                while (k < val.length() && val.charAt(k) == val.charAt(j)) {
                    k++;
                }
                
                nextVal.append(k -j).append(val.charAt(j));
                j = k;
            }
            
            val = nextVal.toString();
        }
        
        return val;
    }
}