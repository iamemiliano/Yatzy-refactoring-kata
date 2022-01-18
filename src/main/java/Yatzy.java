public class Yatzy {

    public static final int ZERO_SCORE = 0;
    public static final int YATZY_SCORE = 50;
    public static final int SMALL_STRAIGHT_SCORE = 15;
    public static final int LARGE_STRAIGHT_SCORE = 20;


    public int chance(Roll roll) {
        return roll.sum();
    }

    public int yatzy(Roll roll) {
        return roll.isYatzy() ? YATZY_SCORE : ZERO_SCORE;
    }

    public int ones(Roll roll) {
        return roll.countDice(1);
    }

    public int twos(Roll roll) {
        return roll.countDice(2) * 2;
    }

    public int threes(Roll roll) {
        return roll.countDice(3) * 3;
    }

    public int fours(Roll roll) {
        return roll.countDice(4) * 4;
    }

    public int fives(Roll roll) {
        return roll.countDice(5) * 5;
    }

    public int sixes(Roll roll) {
        return roll.countDice(6) * 6;
    }

    public int scorePair(Roll roll) {
        int score = 0;
        for (int val = 6; val >= 1; val--) {
            score = roll.findCategory(val, Category.PAIR.getValue());
            if (score > 0) return score;
        }
        return score;
    }

    public int twoPair(Roll roll) {
        int score = 0;
        int pairOccurrence = 0;
        for (int val = 6; val >= 1; val--) {
            int pairScore = roll.findCategory(val, Category.PAIR.getValue());
            if (pairScore > 0) {
                score += pairScore;
                pairOccurrence++;
            }
        }
        return (pairOccurrence == 2) ? score : 0;
    }

    public int fourOfAKind(Roll roll) {
        int score = 0;
        for (int val = 1; val <= 6; val++) {
            score += roll.findCategory(val, Category.FOUR_OF_A_KIND.getValue());
        }
        return score;
    }

    public int threeOfAKind(Roll roll) {
        int score = 0;
        for (int i = 1; i <= 6; i++) {
            score += roll.findCategory(i, Category.THREE_OF_A_KIND.getValue());
        }
        return score;
    }

    public int smallStraight(Roll roll) {
        return roll.isSmallStraight() ? SMALL_STRAIGHT_SCORE : ZERO_SCORE;
    }

    public int largeStraight(Roll roll) {
        return roll.isLargeStraight() ? LARGE_STRAIGHT_SCORE : ZERO_SCORE;
    }

    public int fullHouse(Roll roll) {
        int scorePair = scorePair(roll);
        int threeOfAKind = threeOfAKind(roll);
        int scoreTotal = chance(roll);
        boolean isFullHouse = (scorePair > 0 && threeOfAKind > 0 && scoreTotal == scorePair + threeOfAKind);
        return (isFullHouse) ? scoreTotal : ZERO_SCORE;
    }
}



