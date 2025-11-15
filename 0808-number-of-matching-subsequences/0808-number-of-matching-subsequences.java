class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        int count = 0;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words)
            map.put(word, map.getOrDefault(word, 0) + 1);
        for (String str : map.keySet())
            if (isSubsequence(str, s))
                count+=map.get(str);
        return count;
    }

    public boolean isSubsequence(String s1, String s2) {
        int i = 0, j = 0;
        int n = s1.length(); // smaller string
        int m = s2.length(); // longer string
        while (i < n && j < m) {
            if (s1.charAt(i) == s2.charAt(j))
                i++;
            j++;
        }
        return i == n;
    }
}