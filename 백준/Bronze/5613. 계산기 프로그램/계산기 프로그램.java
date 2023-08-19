import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int sum = sc.nextInt();
        while (true) {
            String str = sc.nextLine();
            if (!str.equals("=")) {
                if ("+".equals(str)) {
                    sum += sc.nextInt();
                } else if ("-".equals(str)) {
                    sum -= sc.nextInt();
                } else if ("*".equals(str)) {
                    sum *= sc.nextInt();
                } else if ("/".equals(str)) {
                    sum /= sc.nextInt();
                }
            } else {
                break;
            }
        }
        System.out.println(sum);
        sc.close();
    }
}