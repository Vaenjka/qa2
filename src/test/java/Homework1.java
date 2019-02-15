import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Homework1 {

    @Test
    public void loan() {
        int loanSum = 90000;
        int firstAnnualInterest = 10;
        int secondAnnualInterest = 8;
        int thirdAnnualInterest = 6;
        int termInYear = 30;

        int period = termInYear / 10;

        int totalSum = calculateTotalSum(loanSum, firstAnnualInterest, secondAnnualInterest, thirdAnnualInterest, period);
        System.out.println("Total credit sum = " + totalSum);

        Assertions.assertEquals(105600, totalSum);
    }

    public int calculateTotalSum(int creditSum, int firstPercent, int secondPercent, int thirdPercent, int period) {
        return ((creditSum) * firstPercent / 100) + ((creditSum / period * 2) * secondPercent / 100)
                + ((creditSum / period) * thirdPercent / 100) + creditSum;
    }
}
