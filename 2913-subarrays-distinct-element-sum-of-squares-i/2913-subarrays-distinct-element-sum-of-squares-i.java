class Solution {
    public int sumCounts(List nums) {
        int totalSum = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            Set set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                totalSum += set.size() * set.size();
            }
        }
        return totalSum;
    }
}