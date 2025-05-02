class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int counter = 0;

        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                dfs(visited, isConnected, i);
                counter++;
            }
        }

        return counter;
    }

    private void dfs(boolean[] visited, int[][] isConected, int currentCity) {
        visited[currentCity] = true;

        for (int i = 0; i < isConected[currentCity].length; i++) {
            if (!visited[i] && isConected[currentCity][i] == 1) {
                dfs(visited, isConected, i);
            }
        }
    }
}