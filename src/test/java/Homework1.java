import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Homework1 {

    @Test
    public void loan() {
        int loanValue = 90000;
        int firstAnnualInterest = 10;
        int secondAnnualInterest = 8;
        int thirdAnnualInterest = 6;
        int termInYear = 30;

        int period = termInYear / 10;

        int totalSum = calculateTotalSum(loanValue, firstAnnualInterest, secondAnnualInterest, thirdAnnualInterest, period);
        System.out.println("Total credit sum = " + totalSum + ".");

        Assertions.assertEquals(105600, totalSum);
    }

    public int calculateTotalSum(int loanValue, int firstAnnualInterest, int secondAnnualInterest, int thirdAnnualInterest, int period) {
        return ((loanValue) * firstAnnualInterest / 100) + ((loanValue / period * 2) * secondAnnualInterest / 100)
                + ((loanValue / period) * thirdAnnualInterest / 100) + loanValue;
    }
}
