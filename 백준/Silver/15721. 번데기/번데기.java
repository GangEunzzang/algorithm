import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine()); // 사람 수
        int T = Integer.parseInt(br.readLine()); // type  몇번째
        int type = Integer.parseInt(br.readLine()); // 0 : 뻔 ,  1 : 데기
        int repeat = 2;
        int typeZeroCount = 0;
        int typeOneCount = 0;

        System.out.println(result(A, T, type, repeat, typeZeroCount, typeOneCount));
    }

    private static int result(int A, int T, int type, int repeat, int typeZeroCount, int typeOneCount) {

        while (true) {
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0) {
                    typeZeroCount++;
                } else {
                    typeOneCount++;
                }

                if (type == 0 && typeZeroCount == T) {
                    return (typeZeroCount + typeOneCount - 1) % A;
                }

                if (type == 1 && typeOneCount == T) {
                    return (typeZeroCount + typeOneCount - 1) % A;
                }

            }

            for (int i = 0; i < repeat; i++) {
                typeZeroCount++;
                if (type == 0 && T == typeZeroCount) {
                    return (typeZeroCount + typeOneCount - 1) % A;
                }

            }

            for (int i = 0; i < repeat; i++) {
                typeOneCount++;
                if (type == 1 && T == typeOneCount) {
                    return (typeZeroCount + typeOneCount - 1) % A;
                }
            }
            
            repeat++;
        }
    }
}