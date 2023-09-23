import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력
        int i = scanner.nextInt();
        int j = scanner.nextInt();

        // 계산
        int a = 100 - i;
        int b = 100 - j;
        int c = 100 - (a + b);
        int d = a * b;

        int q = d / 100;
        int r = d % 100;

        System.out.println(a + " " + b + " " + c + " " + d + " " + q + " " + r);
        System.out.println(c + q + " " + r);
    }
}
