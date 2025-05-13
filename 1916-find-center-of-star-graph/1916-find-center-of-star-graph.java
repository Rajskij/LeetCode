class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> adjacencyMap = new HashMap<>();

        for (int[] arr : edges) {
            adjacencyMap.putIfAbsent(arr[0], new ArrayList<>());
            adjacencyMap.putIfAbsent(arr[1], new ArrayList<>());
            adjacencyMap.get(arr[0]).add(arr[1]);
            adjacencyMap.get(arr[1]).add(arr[0]);
        }

        int result = -1;
        for (int key : adjacencyMap.keySet()) {
            if (result < adjacencyMap.get(key).size()) {
                result = key;
            }
        }

        return result;
    }
}