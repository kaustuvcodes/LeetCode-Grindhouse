class Solution {
    public int[] twoSum(int[] nums, int target) {
        // int i= 0;
        // int j =nums.length-1;
        // while(i<j){
        //     int max= nums[i]+num[j];
        // }
        // if(max==target){
        //     return target;
        // }else(max<target){
        //     i++;
        // }
        // j--;

        for(int i=0;i<nums.length;i++){
            for(int j= i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};

    
    }
    
}