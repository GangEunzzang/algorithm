import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		List<Integer> monthList = List.of(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int sum = 0;

		// 1:월 2:화 3:수 4:목 5:금 6:토 7:일
		int week = 2;

		// 년
		for (int i = 2019; i <= N ; i++) {
			// 월
			for (int j = 1; j <= 12; j++) {
				Integer day = monthList.get(j);
				if ((j == 2 && i % 400 == 0) || (j == 2 && i % 4 == 0 && i % 100 != 0)) {
					day = 29;
				}

				// 일
				for (int k = 1; k <= day; k++) {
					if (k == 13 && week == 5) sum++;
					if (++week > 7) week = 1;
				}
			}
		}

		System.out.println(sum);

	}
}


