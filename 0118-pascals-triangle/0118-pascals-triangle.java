class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> kaustuv = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(kaustuv.get(i - 1).get(j - 1) + kaustuv.get(i - 1).get(j));
            }
            kaustuv.add(row);
        }
        return kaustuv;
    }
}