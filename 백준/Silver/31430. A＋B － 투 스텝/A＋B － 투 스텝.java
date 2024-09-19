import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        if (t == 1) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long k = a + b;
            StringBuilder s = new StringBuilder("aaaaaaaaaaaaa");
            
            for (int i = 0; i < s.length(); i++) {
                if (k > 0) {
                    s.setCharAt(i, (char) ((k % 26) + 'a'));
                    k /= 26;
                } else {
                    break;
                }
            }
            System.out.println(s);
        } else {
            String s = sc.next();
            long ans = 0;
            long r = 1;
            
            for (int i = 0; i < s.length(); i++) {
                ans += (s.charAt(i) - 'a') * r;
                r *= 26;
            }
            System.out.println(ans);
        }
        
        sc.close();
    }
}
