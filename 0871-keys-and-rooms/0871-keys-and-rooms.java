// keys  1, 3
// visited rooms 0
// if key from visited room - remove key
// keys is empty and length visited rom < roms.length return false else true

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> keys = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        dfs(rooms, visited, rooms.get(0), 0);

        return visited.size() == rooms.size();
    }

    private void dfs(List<List<Integer>> rooms, Set<Integer> visited, List<Integer> keys, int currentRoom) {
        visited.add(currentRoom);
        
        for (Integer key : keys) {
            if (!visited.contains(key)) {
                dfs(rooms, visited, rooms.get(key), key);
            }
        }
    }
}