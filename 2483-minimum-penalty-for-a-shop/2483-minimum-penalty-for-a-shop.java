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

    public int bestClosingTime1(String customers) {
        int n = customers.length();
        int pen = 0;
        for (char c : customers.toCharArray()) {
            if (c == 'Y')
                pen++;
        }

        int minpen = pen;
        int bestHour = 0;

        for (int i = 0; i < n; i++) {
            if (customers.charAt(i) == 'Y')
                pen--;
            else
                pen++;
            if (pen < minpen) {
                minpen = pen;
                bestHour = i + 1;
            }
        }

        return bestHour;
    }
}