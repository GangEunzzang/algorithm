import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		while (N-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long a = Long.parseLong(st.nextToken());
			long b = Long.parseLong(st.nextToken());
			sb.append(a * b / gcd(a, b)).append("\n");
		}
		
		System.out.println(sb);
	}

	private static long gcd(long a, long b) {
		if (b == 0) return a;
		return gcd(b, a % b);
	}

}

