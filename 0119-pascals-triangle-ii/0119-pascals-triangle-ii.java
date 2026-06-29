class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> kaustuv = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            kaustuv.add(1);
            for (int j = i - 1; j > 0; j--) {
                kaustuv.set(j, kaustuv.get(j) + kaustuv.get(j - 1));
            }
        }
        return kaustuv;
    }
}