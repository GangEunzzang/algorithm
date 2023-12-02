import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import javax.swing.WindowConstants;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        List<Character> vowelList = List.of('A', 'E', 'I', 'O', 'U');

        while (true) {
            String a = br.readLine();
            if (a.equals("#")) break;
            int vowelCount = 0;
            char[] array = a.toUpperCase().toCharArray();
            for (char c : array) {
                if (vowelList.contains(c)) vowelCount++;
            }
            sb.append(vowelCount).append("\n");
        }

        System.out.println(sb);

    }


}



