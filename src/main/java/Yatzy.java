public class Yatzy {

    public int chance(Roll roll) {
        return roll.sum();
    }

    public int yatzy(Roll roll) {
        return (roll.isYatzy())? 50 : 0;
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

    public int fours(Roll roll)
    {
        return roll.countDice(4) * 4;
    }

    public int fives(Roll roll)
    {
        return roll.countDice(5) * 5;
    }

    public int sixes(Roll roll)
    {
        return roll.countDice(6) * 6;
    }

    public int score_pair(Roll roll)
    {
        int score = 0;
        for(int i=6; i>=1; i--){
            score = roll.category(i, Category.Pair.getValue());
            if(score > 0) return score;
        }
        return score;
    }

    public int two_pair(Roll roll)
    {
        int score = 0;
        int pairOccurrence = 0;
        for(int i=6; i>=1; i--){
            int pairScore = roll.category(i, Category.Pair.getValue());
            if(pairScore > 0){
                score += pairScore;
                pairOccurrence++;
            }
        }
        return (pairOccurrence == 2)? score : 0;
    }

    public int four_of_a_kind(Roll roll)
    {
        int score = 0;
        for(int i=1; i<=6; i++){
            score += roll.category(i, Category.FourOfaKind.getValue());
        }
        return score;
    }

    public int three_of_a_kind(Roll roll)
    {
        int score = 0;
        for(int i=1; i<=6; i++){
            score += roll.category(i, Category.ThreeOfaKind.getValue());
        }
        return score;
    }

    public int smallStraight(Roll roll)
    {
        return roll.isSmallStraight() ? 15 : 0;
    }

    public int largeStraight(Roll roll)
    {
        return roll.isLargeStraight() ? 20 : 0;
    }

    public int fullHouse(Roll roll)
    {
        int scorePair = score_pair(roll);
        int threeOfAKind = three_of_a_kind(roll);
        int scoreTotal = chance(roll);
        return (scorePair > 0 && threeOfAKind > 0 && scoreTotal == scorePair + threeOfAKind)? scoreTotal : 0;
    }
}



