class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> kaustuv=new ArrayList<>();
        solve("",0,0,n,kaustuv);
        return kaustuv;
    }
    
    void solve(String s,int o,int c,int n,List<String> kaustuv){
        if(s.length()==2*n){
            kaustuv.add(s);
            return;
        }
        if(o<n) solve(s+"(",o+1,c,n,kaustuv);
        if(c<o) solve(s+")",o,c+1,n,kaustuv);
    }
}