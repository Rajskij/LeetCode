// we got 6 nodes
// each node have relation one to one like list
// so there is could be node1 -> node2 -> node3 or n1 <- n2 -> n3
// i need to swap N nodes, so every node leads to n0.
// 
// so i can travel srough nodes starting from the first seans its n0(capital)
// and then serch for next node assosiated with n0 and check if there is correct direction
// - if not swap direction, and then gow to the next node marked 1 as visited
// - then i can go to MAP that stores node as a key and asosiated nodes as a value and go though each value
// 

class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            al.add(new ArrayList<>());
        }
        for (int[] conection : connections) {
            int parent = conection[0];
            int child = conection[1];
            al.get(parent).add(child);
            al.get(child).add(-parent);
        }
        return dfs(al, new boolean[n], 0);
    }

    private int dfs(List<List<Integer>> al, boolean[] visited, int node) {
        int count = 0;
        visited[node] = true;

        for (Integer connection : al.get(node)) {
            int con = Math.abs(connection);
            if (!visited[con]) {
                if (connection > 0) {
                    count++;
                }
                count += dfs(al, visited, con);
            }
        }

        return count;
    }
}