class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0;
        int rcol = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int lcol = 0;

        while (top <= bottom && lcol <= rcol) {
            for (int i = lcol; i <= rcol; i++) {
                ans.add(matrix[top][i]);
                // add row on the top
            }
            top++;
            // move top pointer 1 down

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][rcol]);
                // add right col val
            }
            rcol--;
            // move right col pointer to 1 left

            if (top <= bottom) {
                for (int i = rcol; i >= lcol; i--) {
                    ans.add(matrix[bottom][i]);
                    // add row on the bottom
                }
                bottom--;
                // move bottom pointer 1 up
            }

            if (lcol <= rcol) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][lcol]);
                    // add right col val
                }
                lcol++;
                // move left col pointer to 1 right
            }
        }

        return ans;
    }
}