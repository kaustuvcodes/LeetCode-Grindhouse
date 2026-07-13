class Solution {
    public String defangIPaddr(String address) {
        int n = address.length();
        StringBuilder s = new StringBuilder();

        for(int i =0;i<n;i++){
            char ch = address.charAt(i);
            if(ch!='.')
            s.append(ch);
            else
            s.append("[.]");
        }
        return s.toString();
    }
}