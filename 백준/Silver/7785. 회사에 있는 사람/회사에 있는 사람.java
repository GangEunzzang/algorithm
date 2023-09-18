import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<String> companyStayNameSet = new LinkedHashSet<>();

        int N = Integer.parseInt(br.readLine());

        while (N-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String prefix = st.nextToken();

            if (prefix.equals("enter")) companyStayNameSet.add(name);
            if (prefix.equals("leave")) companyStayNameSet.remove(name);
        }

        String result = companyStayNameSet.stream()
                .sorted(Comparator.reverseOrder())
                .map(i -> i + "\n")
                .collect(Collectors.joining());

        System.out.println(result);

    }
}
