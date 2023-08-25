import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 걸그룹 수
        int M = Integer.parseInt(st.nextToken()); // 문제 수

        Map<String, List<String>> memberByGroup = new HashMap<>();
        Map<String, String> groupOfMember = new HashMap<>();

        while (N-- > 0) {
            String groupName = br.readLine();
            int memberCount = Integer.parseInt(br.readLine());
            List<String> memberList = new ArrayList<>();

            while (memberCount-- > 0) {
                String memberName = br.readLine();
                memberList.add(memberName);
                groupOfMember.put(memberName, groupName);
            }

            Collections.sort(memberList);

            memberByGroup.put(groupName, memberList);
        }

        while (M-- > 0) {
            String memberNameOrGroupName = br.readLine();

            String quizCase = br.readLine();

            if (quizCase.equals("0")) {
                memberByGroup.get(memberNameOrGroupName).stream()
                        .map(member -> member + "\n")
                        .forEach(sb::append);
            }


            if (quizCase.equals("1")) {
                sb.append(groupOfMember.get(memberNameOrGroupName) + "\n");
            }


        }

        System.out.println(sb);
        
    }
}
