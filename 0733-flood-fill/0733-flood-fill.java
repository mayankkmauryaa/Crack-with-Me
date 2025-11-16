// // by don't changing the data 
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int initial = image[sr][sc];
//         int[][] ans = image;
//         dfs(image, ans, sr, sc, color, initial);
//         return ans;
//     }

//     public void dfs(int[][] mat, int[][] ans, int sr, int sc, int color, int initial) {
//         int n = mat.length;
//         int m = mat[0].length;
//         ans[sr][sc] = color;
//         for (int i = -1; i <= 1; i++) {
//             for (int j = -1; j <= 1; j++) {
//                 if (Math.abs(i + j) == 1) {
//                     int nr = sr + i;
//                     int nc = sc + j;
//                     if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
//                         if (ans[nr][nc] != color && mat[nr][nc] == initial) {
//                             dfs(mat, ans, nr, nc, color, initial);
//                         }
//                     }
//                 }
//             }
//         }
//     }
// }

// // using visitied array
// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int color) {
//         int n = image.length;
//         int m = image[0].length;
//         int initial = image[sr][sc];
//         if (initial == color)
//             return image;
//         boolean vis[][] = new boolean[n][m];
//         dfs(image, sr, sc, color, vis, initial);
//         return image;
//     }

//     public void dfs(int[][] mat, int sr, int sc, int color, boolean[][] vis, int initial) {
//         int n = mat.length;
//         int m = mat[0].length;
//         vis[sr][sc] = true;
//         mat[sr][sc] = color;
//         for (int i = -1; i <= 1; i++) {
//             for (int j = -1; j <= 1; j++) {
//                 if (Math.abs(i + j) == 1) {
//                     int nr = sr + i;
//                     int nc = sc + j;
//                     if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
//                         if (!vis[nr][nc] && mat[nr][nc] == initial) {
//                             dfs(mat, nr, nc, color, vis, initial);
//                         }
//                     }
//                 }
//             }
//         }
//     }
// }

// without visited array but checking it with the color as to be colored with
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if (initial == color)
            return image;
        dfs(image, sr, sc, color, initial);
        return image;
    }

    public void dfs(int[][] mat, int sr, int sc, int color, int initial) {
        int n = mat.length;
        int m = mat[0].length;
        mat[sr][sc] = color;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(i + j) == 1) {
                    int nr = sr + i;
                    int nc = sc + j;
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if (mat[nr][nc] != color && mat[nr][nc] == initial) {
                            dfs(mat, nr, nc, color, initial);
                        }
                    }
                }
            }
        }
    }
}


