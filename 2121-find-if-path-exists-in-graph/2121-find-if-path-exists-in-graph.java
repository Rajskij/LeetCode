class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();
        boolean[] visited = new boolean[n];

        for (int[] arr : edges) {
            adjacencyMap.putIfAbsent(arr[0], new ArrayList<>());
            adjacencyMap.putIfAbsent(arr[1], new ArrayList<>());
            adjacencyMap.get(arr[0]).add(arr[1]);
            adjacencyMap.get(arr[1]).add(arr[0]);
        }

        return dfs(adjacencyMap, visited, source, destination);
    }

    private boolean dfs(Map<Integer, List<Integer>> map, boolean[] visited, int source, int dist) {
        if (source == dist) {
            return true;
        }
        
        visited[source] = true;
        boolean result = false;
        for (int vert : map.get(source)) {
            if (!visited[vert] && dfs(map, visited, vert, dist)) {
                return true;
            }
        }

        return false;
    }
}