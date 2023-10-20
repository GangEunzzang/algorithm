import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int sum = 0;

		while (N-- > 0) {
			String[] split = br.readLine().split("");
			if(split.length % 2 != 0) continue;

			Stack<String> stack = new Stack<>();

			for (String s : split) {
				if (stack.empty()) {
					stack.add(s);
					continue;
				}

				if (stack.peek().equals(s)) {
					stack.pop();
				} else {
					stack.add(s);
				}
			}

			if (stack.empty()) {
				sum ++;
			}
		}

		System.out.println(sum);
		
	}

}

