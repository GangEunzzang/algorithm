import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static double courseSum; // 학점의 총합
    static double gradeSum; // 학점 * 등급 평점 총합

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();

            double course = Double.parseDouble(st.nextToken());
            String grade = st.nextToken();

            gradeCal(course, grade);

        }

        System.out.printf("%.6f", gradeSum / courseSum);
    }

    static void gradeCal(double course, String grade) {
        double score = 0;

        switch (grade) {
            case "A+": score = 4.5; break;
            case "A0": score = 4.0; break;
            case "B+": score = 3.5; break;
            case "B0": score = 3.0; break;
            case "C+": score = 2.5; break;
            case "C0": score = 2.0; break;
            case "D+": score = 1.5; break;
            case "D0": score = 1.0; break;
            case "F": score = 0.0; break;
            case "P": return;
        }
        courseSum += course;
        gradeSum += course * score;
    }
}