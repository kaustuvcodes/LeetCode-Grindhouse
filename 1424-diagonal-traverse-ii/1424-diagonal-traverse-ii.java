class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        int total = 0;
        int maxDiag = 0;

        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                
                int d = i + j;
                
                if (!map.containsKey(d)) {
                    map.put(d, new ArrayList<>());
                }
                
                map.get(d).add(nums.get(i).get(j));
                
                maxDiag = Math.max(maxDiag, d);
                total++;
            }
        }

        int[] ans = new int[total];
        int k = 0;

        for (int d = 0; d <= maxDiag; d++) {
            List<Integer> list = map.get(d);
            
            if (list == null) continue;
            
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[k++] = list.get(i);
            }
        }

        return ans;
    }
}