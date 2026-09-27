class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int base =0;
        int ans=0;

        HashMap<Integer,Integer> same = new HashMap<>();
        HashMap<String,Integer> pair = new HashMap<>();

        for(int i =1; i<nums.length;i++){
            int a = nums[i-1];
            int b=nums[i];

            if(a==b){
                base++;
                same.put(a,same.getOrDefault(a,0)+1);
            }else{
                String key= Math.min(a,b)+" "+Math.max(a,b);
                pair.put(key,pair.getOrDefault(key,0)+1);
            }
        }
        ans= base;
        for(String key:pair.keySet()){
            
     
            int gain = pair.get(key);
           

            ans = Math.max(ans, base+gain);
        }
        return ans;
    }
}