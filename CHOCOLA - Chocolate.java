import java.util.*;

public class Main {
    static int[][] s = new int[1005][1005];
    static int m, n;
    static List<Integer> a = new ArrayList<>();
    static List<Integer> b = new ArrayList<>();

    public static int f(int i, int j) {
        if (s[i][j] != -1)
            return s[i][j];
        if (i == 0 && j == 0) {
            s[0][0] = 0;
            return s[0][0];
        } else if (i == 0) {
            s[0][j] = (m - i) * b.get(j - 1) + f(i, j - 1);
            return s[0][j];
        } else if (j == 0) {
            s[i][0] = (n - j) * a.get(i - 1) + f(i - 1, j);
            return s[i][0];
        } else {
            int p = (n - j) * a.get(i - 1) + f(i - 1, j);
            int q = (m - i) * b.get(j - 1) + f(i, j - 1);
            s[i][j] = Math.min(p, q);
            return s[i][j];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        while (t-- > 0) {
            m = scanner.nextInt();
            n = scanner.nextInt();
            
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    s[i][j] = -1;
                }
            }

            for (int i = 0; i < m - 1; i++) {
                int x = scanner.nextInt();
                a.add(x);
            }

            for (int i = 0; i < n - 1; i++) {
                int x = scanner.nextInt();
                b.add(x);
            }

            Collections.sort(a);
            Collections.sort(b);

            System.out.println(f(m - 1, n - 1));

            a.clear();
            b.clear();
        }
        scanner.close();
    }
}
