import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] v;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v = new boolean[N + 1];
        choose(0);
    }

    public static void choose(int idx) {

        if(idx == N) {
            print();
            return;
        }

        for(int i=N;i>=1;i--) {
            if(!v[i]) {
                v[i] = true;
                list.add(i);
                choose(idx + 1);
                list.remove(list.size() - 1);
                v[i] = false;
            }
        }
    }

    public static void print() {

        for(int i : list)
            System.out.print(i + " ");
        System.out.println();
    }
}