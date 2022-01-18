import org.junit.*;

import static org.junit.Assert.*;

public class YatzyTest {

    private static Yatzy yatzy;

    @BeforeClass
    public static void setUp(){
        yatzy = new Yatzy();
    }

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = yatzy.chance(new Roll(2,3,4,5,1));
        assertEquals(expected, actual);
        assertEquals(16, yatzy.chance(new Roll(3,3,4,5,1)));
    }

    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = yatzy.yatzy(new Roll(4,4,4,4,4));
        assertEquals(expected, actual);
        assertEquals(50, yatzy.yatzy(new Roll(6,6,6,6,6)));
        assertEquals(0, yatzy.yatzy(new Roll(6,6,6,6,3)));
    }

    @Test public void test_1s() {
        assertTrue(yatzy.ones(new Roll(1,2,3,4,5)) == 1);
        assertEquals(2, yatzy.ones(new Roll(1,2,1,4,5)));
        assertEquals(0, yatzy.ones(new Roll(6,2,2,4,5)));
        assertEquals(4, yatzy.ones(new Roll(1,2,1,1,1)));
    }

    @Test
    public void test_2s() {
        assertEquals(4, yatzy.twos(new Roll(1,2,3,2,6)));
        assertEquals(10, yatzy.twos(new Roll(2,2,2,2,2)));
    }

    @Test
    public void test_threes() {
        assertEquals(6, yatzy.threes(new Roll(1,2,3,2,3)));
        assertEquals(12, yatzy.threes(new Roll(2,3,3,3,3)));
    }

    @Test
    public void fours_test() 
    {
        assertEquals(12, yatzy.fours(new Roll(4,4,4,5,5)));
        assertEquals(8, yatzy.fours(new Roll(4,4,5,5,5)));
        assertEquals(4, yatzy.fours(new Roll(4,5,5,5,5)));
    }

    @Test
    public void fives() {
        assertEquals(10, yatzy.fives(new Roll(4,4,4,5,5)));
        assertEquals(15, yatzy.fives(new Roll(4,4,5,5,5)));
        assertEquals(20, yatzy.fives(new Roll(4,5,5,5,5)));
    }

    @Test
    public void sixes_test() {
        assertEquals(0, yatzy.sixes(new Roll(4,4,4,5,5)));
        assertEquals(6, yatzy.sixes(new Roll(4,4,6,5,5)));
        assertEquals(18, yatzy.sixes(new Roll(6,5,6,6,5)));
    }

    @Test
    public void one_pair() {
        assertEquals(6, yatzy.scorePair(new Roll(3,4,3,5,6)));
        assertEquals(10, yatzy.scorePair(new Roll(5,3,3,3,5)));
        assertEquals(12, yatzy.scorePair(new Roll(5,3,6,6,5)));
    }

    @Test
    public void two_Pair() {
        assertEquals(16, yatzy.twoPair(new Roll(3,3,5,4,5)));
        assertEquals(16, yatzy.twoPair(new Roll(3,3,5,5,5)));
    }

    @Test
    public void three_of_a_kind() 
    {
        assertEquals(9, yatzy.threeOfAKind(new Roll(3,3,3,4,5)));
        assertEquals(15, yatzy.threeOfAKind(new Roll(5,3,5,4,5)));
        assertEquals(9, yatzy.threeOfAKind(new Roll(3,3,3,3,5)));
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, yatzy.fourOfAKind(new Roll(3,3,3,3,5)));
        assertEquals(20, yatzy.fourOfAKind(new Roll(5,5,5,4,5)));
        assertEquals(9, yatzy.threeOfAKind(new Roll(3,3,3,3,3)));
    }

    @Test
    public void smallStraight() {
        assertEquals(15, yatzy.smallStraight(new Roll(1,2,3,4,5)));
        assertEquals(15, yatzy.smallStraight(new Roll(2,3,4,5,1)));
        assertEquals(0, yatzy.smallStraight(new Roll(1,2,2,4,5)));
    }

    @Test
    public void largeStraight() {
        assertEquals(20, yatzy.largeStraight(new Roll(6,2,3,4,5)));
        assertEquals(20, yatzy.largeStraight(new Roll(2,3,4,5,6)));
        assertEquals(0, yatzy.largeStraight(new Roll(1,2,2,4,5)));
    }

    @Test
    public void fullHouse() {
        assertEquals(18, yatzy.fullHouse(new Roll(6,2,2,2,6)));
        assertEquals(0, yatzy.fullHouse(new Roll(2,3,4,5,6)));
    }
}
