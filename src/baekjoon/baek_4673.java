package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class baek_4673 {


    public static void main(String[] args) {


        List<Integer> list = new ArrayList<>();

        for(int i = 1; i <= 10000; i++ ) {
            list.add(i);
        }

        for(int i = 1; i <= 10000 ; i++) {

            int sum = 0;

            int j = i;

            if (j > 0) {
                sum += j % 10;
                j /= 10;
                list.remove(sum);
            }

        }

        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

}
