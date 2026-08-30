package week3.assignments;

public class TrafficSignal {

    static void findLongestStreak(String signalLog) {

        int currentCount = 1;
        int maxCount = 1;

        char currentColor = signalLog.charAt(0);
        char longestColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentCount++;
            } else {
                currentCount = 1;
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                longestColor = signalLog.charAt(i);
            }
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + maxCount + " times");
    }

    public static void main(String[] args) {

        findLongestStreak("RRGGYRR");

    }
}