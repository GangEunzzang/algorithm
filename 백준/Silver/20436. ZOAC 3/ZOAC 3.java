import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static Point leftHand;
    private static Point rightHand;

    private static List<Character> rightList = new ArrayList<>();
    private static Map<Character, Point> keyboard = new HashMap<>();
    private static int count;
    private static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y =y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String left = st.nextToken();
        String right = st.nextToken();
        initData();

        leftHand = keyboard.get(left.charAt(0));
        rightHand = keyboard.get(right.charAt(0));

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Point point = keyboard.get(c);

            if (rightList.contains(c)) {
                int diff = Math.abs(rightHand.x - point.x) + Math.abs(rightHand.y - point.y);
                count += diff + 1;
                rightHand = point;
            } else {
                int diff = Math.abs(leftHand.x - point.x) + Math.abs(leftHand.y - point.y);
                count += diff + 1;
                leftHand = point;
            }
        }

        System.out.println(count);

    }

    private static void initData() {
        keyboard.put('q', new Point(0, 0));
        keyboard.put('w', new Point(0, 1));
        keyboard.put('e', new Point(0, 2));
        keyboard.put('r', new Point(0, 3));
        keyboard.put('t', new Point(0, 4));
        keyboard.put('y', new Point(0, 5));
        keyboard.put('u', new Point(0, 6));
        keyboard.put('i', new Point(0, 7));
        keyboard.put('o', new Point(0, 8));
        keyboard.put('p', new Point(0, 9));

        keyboard.put('a', new Point(1, 0));
        keyboard.put('s', new Point(1, 1));
        keyboard.put('d', new Point(1, 2));
        keyboard.put('f', new Point(1, 3));
        keyboard.put('g', new Point(1, 4));
        keyboard.put('h', new Point(1, 5));
        keyboard.put('j', new Point(1, 6));
        keyboard.put('k', new Point(1, 7));
        keyboard.put('l', new Point(1, 8));

        keyboard.put('z', new Point(2, 0));
        keyboard.put('x', new Point(2, 1));
        keyboard.put('c', new Point(2, 2));
        keyboard.put('v', new Point(2, 3));
        keyboard.put('b', new Point(2, 4));
        keyboard.put('n', new Point(2, 5));
        keyboard.put('m', new Point(2, 6));

        rightList.add('y');
        rightList.add('u');
        rightList.add('i');
        rightList.add('o');
        rightList.add('p');
        rightList.add('h');
        rightList.add('j');
        rightList.add('k');
        rightList.add('l');
        rightList.add('b');
        rightList.add('n');
        rightList.add('m');
    }
}
