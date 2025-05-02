// keys  1, 3
// visited rooms 0
// if key from visited room - remove key
// keys is empty and length visited rom < roms.length return false else true

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Deque<Integer> keys = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        keys.push(0);
        
        while (!keys.isEmpty()) {
            int key = keys.pop();
            visited.add(key);

            for (Integer k : rooms.get(key)) {
                if (!visited.contains(k)) {
                    keys.push(k);
                }
            }
        }

        return visited.size() == rooms.size();
    }
}