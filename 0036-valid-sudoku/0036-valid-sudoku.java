class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<Integer, Set<Character>> boxs = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            rows.put(i, new HashSet<>());
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c != '.') {
                    Set curRow = rows.get(i);
                    Set curColumn = columns.computeIfAbsent(j, s -> new HashSet<>());
                    int boxIdx = (i / 3) * 3 + j / 3;
                    Set curBox = boxs.computeIfAbsent(boxIdx, s -> new HashSet<>());
                    
                    if (curRow.contains(c) || curColumn.contains(c) || curBox.contains(c)) {
                        return false;
                    }

                    curRow.add(c);
                    curColumn.add(c);
                    curBox.add(c);
                }
            }
        }

        return true;
    }
}
