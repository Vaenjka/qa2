import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JavaBasics {

    @Test
    public void javaBasic() {
        int a = 10000;
        int b = 10;

        int c = sumDigits(a, b);
        System.out.println("Result = " + c + ".");

        Assertions.assertEquals(10010, c, "sum is not correct");
    }

    private int sumDigits(int a, int b) {
        return a + b;
    }
}
