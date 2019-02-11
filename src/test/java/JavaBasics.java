import org.junit.jupiter.api.Test;

public class JavaBasics {

    @Test
    public void javaBasic() {
        int a = 13;
        int b = 10;

        int c = sumDigits(a, b);
        System.out.println("Result = " + c + ".");
    }

    private int sumDigits(int a, int b) {
        return a + b;
    }
}
