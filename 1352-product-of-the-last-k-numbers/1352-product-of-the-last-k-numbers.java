class ProductOfNumbers {
    List<Integer> list;

    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        list.add(num);
    }
    
    public int getProduct(int k) {
        int size = list.size(), product = 1;

        for (int i = size-1; i >= size-k; i--) {
            product *= list.get(i);
        }

        return product;
    }
}