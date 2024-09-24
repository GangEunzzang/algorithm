
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int R = toInt(st.nextToken());
        int C = toInt(st.nextToken()) - 3;

        List<Team> list = new ArrayList<>();

        while (R-- > 0) {
            char[] charArray = br.readLine().toCharArray();

            for (int i = 0; i < C; i++) {
                char c = charArray[i];
                if (Character.isDigit(c)) {
                    int numericValue = Character.getNumericValue(c);
                    list.add(new Team(numericValue,  i));
                    break;
                }
            }
        }

        list.sort((o1, o2) -> o2.location - o1.location);

        int curRank = list.get(0).rank = 1;
        int curLocation = list.get(0).location;

        for (int i = 1; i < list.size(); i++) {
            Team curTeam = list.get(i);
            if (curTeam.location == curLocation) {
                curTeam.rank = curRank;
            } else {
                curTeam.rank = ++curRank;
                curLocation = curTeam.location;
            }
        }

        list.sort((o1, o2) -> o1.teamNumber - o2.teamNumber);

        for (Team team : list) {
            sb.append(team.rank).append("\n");
        }

        System.out.println(sb);

    }

    private static int toInt(String val) {
        return Integer.parseInt(val);
    }

    private static class Team {
        int teamNumber;
        int rank;

        int location;

        @Override
        public String toString() {
            return "Team{" +
                    "teamNumber=" + teamNumber +
                    ", rank=" + rank +
                    ", location=" + location +
                    '}';
        }

        public Team(int teamNumber, int location) {
            this.teamNumber = teamNumber;
            this.location = location;
        }

    }

}
