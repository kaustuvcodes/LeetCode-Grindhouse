class Solution {
    int n;

    public int gcdTwo(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int lcmTwo(int a, int b) {
        return (a / gcdTwo(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        n = nums.length;
        int count = 0;

        for(int i = 0; i < n; i++){
            int lc = nums[i];
            int gc = nums[i];
            int pr = nums[i];

            for(int j = i + 1; j < n; j++){
                pr *= nums[j];
                gc = gcdTwo(gc , nums[j]);
                lc = lcmTwo(lc , nums[j]);

                if(pr == gc * lc){
                    count = Math.max(count , j - i + 1);
                }
            }
        }
        return count;
    }
}