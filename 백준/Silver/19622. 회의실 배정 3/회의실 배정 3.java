import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	/**
	 *  회의는 끝나는 시간과 동시에 시작될 수 있다.
	 *  한 회의실에서 동시에 회의가 진행될 수 없다.
	 *  한번 시작하면 중간에 종료할 수 없다.
	 *  최대 인원을 구하라
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N];
		List<Meeting> meetings = new ArrayList<>();

		int idx = N;
		while (idx-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings.add(new Meeting(
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken()),
				Integer.parseInt(st.nextToken())
				)
			);
		}


		dp[0] = meetings.get(0).peopleNumber;
		int answer = dp[0];

		if (N >= 2) {
			dp[1] = meetings.get(1).peopleNumber;
		}

		for (int i = 2; i < N; i++) {
			dp[i] = answer + meetings.get(i).peopleNumber;
			answer = Math.max(answer, dp[i-1]);
		}

		System.out.println(Math.max(answer, dp[N -1]));

	}

	private static class Meeting {
		int startTime;
		int endTime;
		int peopleNumber;

		Meeting(int startTime, int endTime, int peopleNumber) {
			this.startTime = startTime;
			this.endTime = endTime;
			this.peopleNumber = peopleNumber;
		}

	}

}


