class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> visited = new HashSet<>();
        int x = 0;
        int y = 0;
        visited.add("0,0");

        for (char c : path.toCharArray()) {
            if (c == 'N') {
                y++;
            } else if (c == 'S') {
                y--;
            } else if (c == 'E') {
                x++;
            } else if (c == 'W') {
                x--;
            }

            String currentPos = x + "," + y;
            if (visited.contains(currentPos)) {
                return true;
            }
            visited.add(currentPos);
        }

        return false;
    }
}