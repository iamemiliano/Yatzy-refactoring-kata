import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Roll {

    private int[] dices;

    public Roll(int d1, int d2, int d3, int d4, int d5) {
        this.dices = new int[]{d1, d2, d3, d4, d5};
    }

    public int countDice(int number) {
        return (int) IntStream.range(0, dices.length).filter(index -> dices[index] == number).count();
    }

    public int sum() {
        return Arrays.stream(dices).sum();
    }

    public int findCategory(int diceNumber, int occurenceCategory) {
        return (countDice(diceNumber) >= occurenceCategory) ? diceNumber * occurenceCategory : 0;
    }

    public boolean isYatzy() {
        int counts = 0;
        int diceValue = 0;
        for (int die : dices) {
            if (diceValue == 0 || diceValue == die) {
                diceValue = die;
                counts++;
            }
        }
        return (counts == 5) ? true : false;

    }

    public boolean isSmallStraight() {
        List<Integer> listSmallStraight = List.of(countDice(1),
            countDice(2),
            countDice(3),
            countDice(4),
            countDice(5));
        return listSmallStraight.stream().allMatch(countDice -> (countDice == 1));
    }

    public boolean isLargeStraight() {
        List<Integer> listLargeStraight = List.of(countDice(2),
            countDice(3),
            countDice(4),
            countDice(5),
            countDice(6));
        return listLargeStraight.stream().allMatch(countDice -> (countDice == 1));
    }

}
