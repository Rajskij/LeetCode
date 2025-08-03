// init
// 1 2 3
// 4 5 6
// 7 8 9

// Transpose the matrix
// transposing state
// 1 4 7
// 2 5 8 
// 3 6 9

// reverse each row
// resloved
// 7 4 1
// 8 5 2
// 9 6 3

class Solution {
    public void rotate(int[][] matrix) {
        int l = matrix.length;

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }    

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][l - j - 1];
                matrix[i][l - j - 1] = tmp;
            }
        }
    }
}
