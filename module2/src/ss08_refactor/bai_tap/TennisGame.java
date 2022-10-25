package ss08_refactor.bai_tap;

public class TennisGame {
    private static final int LOVE_ALL = 0;
    private static final int FIFTEEN_ALL = 1;
    private static final int THIRTY_ALL = 2;
    private static final int FORTY_ALL = 3;

    public static String getAnnouncement(String playerA, String playerB, int scoreA, int scoreB) {
        if (scoreA == scoreB) {
            return equalScore(scoreA);
        } else if (scoreA >= 4 || scoreB >= 4) {
            return moreThanFour(scoreA - scoreB);
        } else {
            return otherCases(scoreA) + "-" + otherCases(scoreB);
        }
    }

    public static String equalScore(int score) {
        switch (score) {
            case LOVE_ALL:
                return "Love-All";
            case FIFTEEN_ALL:
                return "Fifteen-All";
            case THIRTY_ALL:
                return "Thirty-All";
            case FORTY_ALL:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    public static String moreThanFour(int minusScore) {
        return minusScore == 1 ? "Advantage player1" : minusScore == -1 ? "Advantage player2" : minusScore >= 2 ? "Win for player1" : "Win for player2";
    }

    public static String otherCases(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            default:
                return "Forty";
        }
    }
}