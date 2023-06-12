import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            String pw = br.readLine();
            List<Character> list = new LinkedList<>();
            ListIterator<Character> iter = list.listIterator();

            for (int i = 0; i < pw.length(); i++) {
                char c = pw.charAt(i);
                switch (c) {
                    case '<':
                        if (iter.hasPrevious()) {
                            iter.previous();
                        }
                        break;

                    case '>':
                        if (iter.hasNext()) {
                            iter.next();
                        }
                        break;
                    case '-':
                        if (iter.hasPrevious()) {
                            iter.previous();
                            iter.remove();
                        }
                        break;
                    default:
                        iter.add(c);
                }
            }

            for (Character c : list) sb.append(c);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}