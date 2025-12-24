class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> EachRow = new ArrayList<>();
            long ans = 1;
            EachRow.add(1);
            for (int col = 1; col <= row; col++) {
                ans = ans * (row - col + 1) / col; // triangle = (row - col) / col
                EachRow.add((int) ans);
            }
            triangle.add(EachRow);
        }
        return triangle;
    }
}
