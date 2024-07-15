import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static StringTokenizer st;
    static List<Integer> answer = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        choose(1, 1);
    }

    public static void print() {
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    public static void choose(int currNum, int idx) {

        if(currNum == M + 1) {
            print();
            return;
        }

        for(int i=idx;i<=N;i++) {
            answer.add(i);
            choose(currNum + 1, i + 1);
            answer.remove(answer.size() - 1);
        }

        }
    }