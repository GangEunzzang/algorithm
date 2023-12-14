import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static List<Student> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = toInt(br.readLine());

        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            list.add(new Student(toInt(st.nextToken()), st.nextToken()));
        }

        Collections.sort(list, ((o1, o2) -> {
            if (o1.age != o2.age) return o1.age - o2.age;
            return 0;
        }));

        for (Student student : list) {
            sb.append(student.age).append(" ").append(student.name).append("\n");
        }

        System.out.println(sb);
    }

    static int toInt(String val) {
        return Integer.parseInt(val);
    }

    static class Student {
        int age;
        String name;

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }


}

