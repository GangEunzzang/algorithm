import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine());

        int lies = Integer.parseInt(st.nextToken());

        if (lies == 0) {
            System.out.println(m);
            return;
        }

        List<Integer> truePeopleList = new ArrayList<>();
        for (int i = 0; i < lies; i++) {
            truePeopleList.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> partyPeopleList = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int peopleCount = Integer.parseInt(st.nextToken());
            partyPeopleList.add(new ArrayList<>());

            if (peopleCount == 0) continue;

            int tmp = Integer.parseInt(st.nextToken());
            partyPeopleList.get(i).add(tmp);
            peopleCount--;

            while (peopleCount-- > 0) {
                int peopleNumber = Integer.parseInt(st.nextToken());
                union(tmp, peopleNumber);
                tmp = peopleNumber;

                partyPeopleList.get(i).add(tmp);
            }

        }


        int answer = 0;
        for (List<Integer> partyList : partyPeopleList) {
            if (partyList.size() == 0) continue;
            boolean flag = true;
            for (Integer peopleNum : partyList) {
                for (Integer truePeoPleNum : truePeopleList) {
                    if (find(peopleNum) == find(truePeoPleNum)) {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                answer++;
            }
        }

        System.out.println(answer);


    }

    private static int find(int x) {
        if (x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }

    }


}