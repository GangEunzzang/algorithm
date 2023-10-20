import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		ORDER order = null;
		String lastWord = null;

		while (N-- > 0) {
			String currentWord = br.readLine();
			if (lastWord == null) {
				lastWord = currentWord;
				continue;
			}

			int compare = lastWord.compareTo(currentWord);

			if (order == null) {
				if (compare < 0) order = ORDER.INCREASING;
				if (compare > 0) order = ORDER.DECREASING;
				lastWord = currentWord;
				continue;
			}

			switch (order) {
				case INCREASING:
					if (compare > 0) {
						System.out.println(ORDER.NEITHER);
						return;
					}
					break;
					
				case DECREASING:
					if (compare < 0) {
						System.out.println(ORDER.NEITHER);
						return;
					}
					break;
			}

			lastWord = currentWord;
		}

		System.out.println(order);

	}

	enum ORDER {
		INCREASING, DECREASING, NEITHER
	}

}

