class Solution {
    public boolean halvesAreAlike(String s) {
        int c1=0;
        int c2=0;
        int mid = s.length()/2;
        for(int i=0;i<mid;i++){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
               ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                c1++;
            }
        }
        for(int i=mid;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||
               ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U'){
                c2++;
            }
        }
        return c1==c2;
    }
}