class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int i = 1;
        int j = 0;

        for (int pile : piles) {
            j = Math.max(j, pile);
        }

        while (i < j) {
            int k = i + (j - i) / 2;

            int time = 0;
            for (int x = 0; x < piles.length; x++) {
                time += (piles[x] + k - 1) / k;
            }

            if (time > h)
                i = k + 1;
            else
                j = k;
        }

        return i;
    }
}