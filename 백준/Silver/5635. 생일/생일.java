import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Student> list = new ArrayList<>();

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new Student(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, ((o1, o2) -> {
            if (o1.year != o2.year) return Integer.compare(o1.year, o2.year);
            if (o1.month != o2.month) return Integer.compare(o1.month, o2.month);
            return Integer.compare(o1.day, o2.day);
        }));

        System.out.println(list.get(list.size() -1).name);
        System.out.println(list.get(0).name);
        

    }

    private static class Student {
        String name;
        int year;
        int month;
        int day;

        public Student(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

}
