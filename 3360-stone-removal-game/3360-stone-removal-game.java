class Solution {
    public boolean canAliceWin(int n) {
        int r = 10;
        int turn = 0;

        while(n >= r){
            n -= r;
            r--;
            turn++;
        }
        return turn % 2 == 1;
    }
}