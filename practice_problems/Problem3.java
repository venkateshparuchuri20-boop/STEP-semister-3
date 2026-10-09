package week3.practice_problems;


import java.util.Arrays;

class LibraryMember {
    private int[] fineHistory = new int[0];

    protected void chargeFine(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Fine cannot be negative");
        }

        fineHistory = Arrays.copyOf(fineHistory, fineHistory.length + 1);
        fineHistory[fineHistory.length - 1] = amount;
    }

    public int[] getFineHistory() {
        return Arrays.copyOf(fineHistory, fineHistory.length);
    }

    public int getTotalFine() {
        int total = 0;

        for (int fine : fineHistory) {
            total += fine;
        }

        return total;
    }
}

class StudentMember extends LibraryMember {
    @Override
    protected void chargeFine(int amount) {
        super.chargeFine(amount / 2);
    }
}

public class Problem3 {
    public static void main(String[] args) {
        StudentMember s = new StudentMember();

        s.chargeFine(100);
        System.out.println(s.getTotalFine());

        int[] history = s.getFineHistory();
        history[0] = 999;

        System.out.println(Arrays.toString(s.getFineHistory()));
    }
}

