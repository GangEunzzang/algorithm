import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        List<String> students = new ArrayList<>();
        while (N-- > 0) {
            students.add(br.readLine());
        }

        int nameSize = students.get(0).length();

        int K = 0;
        first:
        while (K++ <= 100) {
            Set<String> set = new HashSet<>();

            for (String student : students) {
                String substring = student.substring(nameSize - K);
                if (set.contains(substring)) {
                    continue first;
                }
                set.add(substring);
            }

            System.out.println(K);
            return;
        }


    }

}
