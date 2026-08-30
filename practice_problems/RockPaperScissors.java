package week3.practice_problems;

import java.util.Random;

public class RockPaperScissors {

    static String playRound(String playerMove, String computerMove) {

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        if (
                (playerMove.equalsIgnoreCase("Rock") &&
                        computerMove.equalsIgnoreCase("Scissors")) ||

                        (playerMove.equalsIgnoreCase("Paper") &&
                                computerMove.equalsIgnoreCase("Rock")) ||

                        (playerMove.equalsIgnoreCase("Scissors") &&
                                computerMove.equalsIgnoreCase("Paper"))
        ) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {

        String[] playerMoves = {
                "Rock", "Paper", "Scissors", "Rock", "Paper"
        };

        String[] moves = {
                "Rock", "Paper", "Scissors"
        };

        Random random = new Random();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        for (int i = 0; i < playerMoves.length; i++) {

            String computerMove =
                    moves[random.nextInt(3)];

            String result =
                    playRound(playerMoves[i], computerMove);

            System.out.println(
                    "Round " + (i + 1) +
                            " | Player: " + playerMoves[i] +
                            " | Computer: " + computerMove +
                            " | " + result
            );

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        double winPercentage =
                ((double) wins / playerMoves.length) * 100;

        System.out.println("\nFinal Summary");
        System.out.println(
                "Wins: " + wins +
                        " | Losses: " + losses +
                        " | Draws: " + draws
        );

        System.out.printf("Win %% = %.1f%%\n", winPercentage);
    }
}