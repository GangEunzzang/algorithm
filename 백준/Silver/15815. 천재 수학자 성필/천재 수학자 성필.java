import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) throws IOException {
        char[] arr = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();

        Stack<Integer> stack = new Stack<>();


        for (char c : arr) {
            if (Character.isDigit(c)) {
                stack.add(c - '0');
                continue;
            }

            Integer one = stack.pop();
            Integer two = stack.pop();

            switch (c) {
                case '+':
                    stack.add(one + two);
                    break;
                case '-':
                    stack.add(two - one);
                    break;
                case '*':
                    stack.add(one * two);
                    break;
                case '/':
                    stack.add(two / one);
                    break;
            }
        }

        System.out.println(stack.pop());


    }


}

