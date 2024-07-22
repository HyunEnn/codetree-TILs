import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static boolean[] v;
    static List<Integer> list = new ArrayList<>();
    static StringTokenizer st;
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

        for(int i=1;i<=N;i++) {
            if(!v[i]) {
                v[i] = true;
                list.add(i);
                choose(idx + 1);
                list.remove(list.size() - 1);
                v[i]= false;
            }
        }
    }

    public static void print() {

        for(int i : list)
            System.out.print(i + " ");
        System.out.println();
    }
}