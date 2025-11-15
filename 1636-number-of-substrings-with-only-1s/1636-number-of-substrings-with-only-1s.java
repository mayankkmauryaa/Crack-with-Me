class Solution {
    public int numSub(String s) {
        // int count = 0 // sol 4
        long count = 0;
        int ones = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '0')
                ones = 0;
            else
                count += ++ones;
        }
        // return count;  // sol 1
        // return count%(1000_000_000+7);  // sol 2
        return (int) (count % (1_000_000_000 + 7));     // sol 3
    }
}