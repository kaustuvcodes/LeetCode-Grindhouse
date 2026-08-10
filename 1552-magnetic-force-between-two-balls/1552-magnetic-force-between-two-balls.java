class Solution {

    boolean isPossible(int[] position , int  mid , int m){
        int lastPosition = position[0];
        int totalBallPlaced = 1;

        for(int i=1; i<position.length; i++){
            if(position[i] - lastPosition >= mid){
                lastPosition = position[i];
                totalBallPlaced++;
            }
        }

        return totalBallPlaced >= m;
    }
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);
        int min = position[0];
        int max = position[n-1];

        int left = 1;
        int right = max - min;
        int ans = -1;

        while(left <= right){
            int mid = left + (right - left) / 2;

            if(isPossible(position , mid , m)){
                left = mid + 1;
                ans = mid;
            }else{
                right = mid - 1;
            }
        }

        return ans;
    }
}