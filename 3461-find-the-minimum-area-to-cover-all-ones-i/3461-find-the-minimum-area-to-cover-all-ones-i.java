// class Solution {
//     public int minimumArea(int[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;

//         int minRow = n;
//         int maxRow = -1;
//         int minCol = m;
//         int maxCol = -1;

//         for (int i = 0; i < n; i++) {
//             for (int j = 0; j < m; j++) {
//                 if (grid[i][j] == 1) {
//                     minRow = Math.min(minRow, i);
//                     maxRow = Math.max(maxRow, i);
//                     minCol = Math.min(minCol, j);
//                     maxCol = Math.max(maxCol, j);
//                 }
//             }
//         }
//         int height = maxRow - minRow + 1;
//         int width = maxCol - minCol + 1;

//         return height * width;
//     }
// }

class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int minRow = 0;
        int maxRow = 0;
        int minCol = 0;
        int maxCol = 0;

        boolean flag = false;

        // check for first 1 in row wise
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    minRow = i;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        flag = false;

        // check for last 1 in row wise
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    maxRow = i;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        flag = false;

        // check for first 1 in col wise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    minCol = i;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }
        flag = false;
        // check for last 1 in col wise
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (grid[j][i] == 1) {
                    maxCol = i;
                    flag = true;
                    break;
                }
            }
            if (flag)
                break;
        }

        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;

        return height * width;
    }
}