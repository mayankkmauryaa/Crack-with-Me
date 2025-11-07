class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        backtrack(ans, list, candidates, 0, target);
        return ans;
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> list, int arr[], int idx, int sum) {
        if (sum < 0)
            return;
        else if (sum == 0)
            ans.add(new ArrayList<>(list));
        else {
            for (int i = idx; i < arr.length; i++) {
                if (i > idx && arr[i] == arr[i - 1])
                    continue;
                list.add(arr[i]);
                backtrack(ans, list, arr, i+1, sum - arr[i]);
                list.remove(list.size() - 1);

            }
        }
    }
}