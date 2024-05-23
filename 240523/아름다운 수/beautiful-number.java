import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int cnt;
    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = 0;
        list = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        recursive(0);
        System.out.println(cnt);
    }

    public static void recursive(int x) {

        // basis
        if (x == N) {
            if (check())
                cnt++;
            return;
        }

        // inductive
        for (int i = 1; i <= 3; i++) {
            list.add(i);
            recursive(x + 1);
            list.remove(list.size() - 1);
        }
    }

    public static boolean check() {

        for (int i = 0; i < N; i++) {
            int num = list.get(i);
            int k = 1;

            while (i <= N - 2) {
                if (list.get(i + 1) != num)
                    break;
                k++;
                i++;
            }

            if (k % num != 0)
                return false;
        }

        return true;
    }
}