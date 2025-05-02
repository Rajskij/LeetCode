// keys  1, 3
// visited rooms 0
// if key from visited room - remove key
// keys is empty and length visited rom < roms.length return false else true

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> keys = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        rooms.get(0).forEach(i -> keys.push(i));
        visited.add(0);
        
        while (!keys.isEmpty()) {
            int key = keys.pop();
            List<Integer> curKeys = rooms.get(key);
            visited.add(key);

            for (Integer k : curKeys) {
                if (!visited.contains(k)) {
                    keys.push(k);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}