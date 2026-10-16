class Solution {
    public int findLHS(int[] nums) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int maxLength = 0;
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxLength = Math.max(maxLength, map.get(key) + map.get(key + 1));
            }
        }
        return maxLength;
    }
}