import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


class Solution {
    public int solution(int k, int m, int[] score) {

        List<Integer> ab = new ArrayList<>();

        for (int i : score) {
            ab.add(i);
        }

        ab.sort(Comparator.reverseOrder());

        int result = 0;

        for (int i = 0; i < ab.size()/m; i++) {
            result += ab.get((i * m) + m-1) * m;
        }

        return result;
    }
}