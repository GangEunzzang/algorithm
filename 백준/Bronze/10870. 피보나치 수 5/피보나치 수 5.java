
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int sum = 0;


        List<Integer> a = new ArrayList<>();
        a.add(0);


        for (int i = 1; i <= n; i++) {

            if (i == 1) {
                a.add(1);
            } else {
                a.add(a.get(i-2) + a.get(i-1));
            }
        }

        System.out.println(a.get(n));


    }

}
