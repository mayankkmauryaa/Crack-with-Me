class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0)
                return false;
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (used[i])
                continue;
            List<String> list = new ArrayList<>();
            list.add(strs[i]);
            used[i] = true;

            for (int j = i + 1; j < n; j++) {
                if (!used[j] && isAnagram(strs[i], strs[j])) {
                    list.add(strs[j]);
                    used[j] = true;
                }
            }
            Collections.sort(list);
            ans.add(list);
        }
        return ans;
    }
}
