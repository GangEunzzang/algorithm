import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String s = new Scanner(System.in).next();
        System.out.println(s.equals(new StringBuilder(s).reverse().toString()) ? "true" : "false");
    }
}

