package baekjoon;

import java.util.Arrays;

public class baek_15596 {

    long sum(int[] a ) {

        return Arrays.stream(a).asLongStream().sum();

    }
}
