// keys  1, 3
// visited rooms 0
// if key from visited room - remove key
// keys is empty and length visited rom < roms.length return false else true

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        Deque<Integer> keys = new ArrayDeque<>();
        keys.push(0);
        
        while (!keys.isEmpty()) {
            int key = keys.pop();
            visited[key] = true;

            for (Integer k : rooms.get(key)) {
                if (visited[k] == false) {
                    keys.push(k);
                    visited[k] = true;
                }
            }
        }

        for (boolean isVisited : visited) {
            if (!isVisited) {
                return false;
            }
        }
        return true;
    }
}