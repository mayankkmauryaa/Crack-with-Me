class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int pen = 0;

        int minpen = 0;
        int bestHour = 0;

        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y') {
                pen--;
                if (pen < minpen) {
                    minpen = pen;
                    bestHour = i + 1;
                }
            } else
                pen++;
        }

        return bestHour;
    }
}
