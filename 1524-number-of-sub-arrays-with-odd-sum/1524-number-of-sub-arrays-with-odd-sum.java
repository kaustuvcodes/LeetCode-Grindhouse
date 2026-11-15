class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int count = 0, odd = 0, even = 0, mod = 1_000_000_007;
        int prefix = arr[0];

        if (prefix % 2 != 0) {
            count++;
            odd++;
        }
        else {
            even++;
        }

        for (int i = 1; i < n; i++) {
            prefix += arr[i];

            if (prefix % 2 != 0) {
                odd++;
                count = (count + even + 1) % mod;
            }
            else {
                even++;
                count = (count + odd) % mod;
            }
        }

        return count;
    }
}