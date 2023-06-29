import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigDecimal num = new BigDecimal(sc.next()).sqrt(MathContext.DECIMAL64);
		BigDecimal gop = num.multiply(BigDecimal.valueOf(4), MathContext.DECIMAL64);
		System.out.println(gop);
		sc.close();
	}
}