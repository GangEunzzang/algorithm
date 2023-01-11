package baekjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class baek_2908 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String AA = sc.next();
        String BB = sc.next();

        StringBuilder sb = new StringBuilder();
        int A = Integer.parseInt(String.valueOf(sb.append(AA).reverse()));

        sb.setLength(0);

        int B = Integer.parseInt(String.valueOf(sb.append(BB).reverse()));

        System.out.println(Math.max(A, B));
    }
}
