import java.util.*;

public class Roll {

    private int[] dices;

    public Roll(int d1, int d2, int d3, int d4, int d5){
        this.dices = new int[]{d1, d2, d3, d4, d5};
    }

    public int countDice(int number) {
        int occurrencesNumber = 0;
        for (int i = 0; i < dices.length; i++)
            if (number == dices[i]) occurrencesNumber++;
        return occurrencesNumber;
    }

    public int sum(){
        return Arrays.stream(dices).sum();
    }

    public int category(int number, int occurenceCategory) {
        return (countDice(number) >= occurenceCategory)? number * occurenceCategory : 0;
    }

    public boolean isYatzy(){
        int counts = 0;
        int diceValue = 0;
        for (int die : dices){
            if (diceValue == 0 || diceValue == die){
                diceValue = die;
                counts++;
            }
        }
        return (counts == 5)? true : false;
    }

    public boolean isSmallStraight(){
        return (countDice(1) == 1
            && countDice(2) == 1
            && countDice(3) == 1
            && countDice(4) == 1
            && countDice(5) == 1);
    }

    public boolean isLargeStraight(){
        return (countDice(6) == 1
            && countDice(2) == 1
            && countDice(3) == 1
            && countDice(4) == 1
            && countDice(5) == 1);
    }

}
