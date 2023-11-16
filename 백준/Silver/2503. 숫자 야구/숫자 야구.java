import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Baseball> baseballList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            baseballList.add(new Baseball(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int answer = 0;

        first:
        for (int i = 111; i <= 999; i++) {
            int hundred = i / 100;
            int ten = i % 100 / 10;
            int one = i % 100 % 10;
            if (hundred == ten || hundred == one || ten == one ||
               hundred == 0 || ten == 0 || one == 0 ) continue ;

            for (Baseball baseball : baseballList) {
                int strikeCount = 0;
                int ballCount = 0;

                if (baseball.numList.contains(hundred)) {
                    if (baseball.hundred == hundred) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }

                if (baseball.numList.contains(ten)) {
                    if (baseball.ten == ten) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }

                if (baseball.numList.contains(one)) {
                    if (baseball.one == one) {
                        strikeCount++;
                    } else {
                        ballCount++;
                    }
                }

                if (baseball.strike != strikeCount || baseball.ball != ballCount) {
                    continue first;
                }
            }
            answer++;
        }
        System.out.println(answer);

    }

    private static class Baseball {
        private int one;
        private int ten;
        private int hundred;
        private int strike;
        private int ball;

        private List<Integer> numList;

        public Baseball(String val, int strike, int ball) {
            this.hundred = Character.getNumericValue(val.charAt(0));
            this.ten = Character.getNumericValue(val.charAt(1));
            this.one = Character.getNumericValue(val.charAt(2));
            this.strike = strike;
            this.ball = ball;
            this.numList = List.of(hundred, ten, one);
        }

    }


}