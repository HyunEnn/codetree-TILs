import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[] arr;
    static List<String> binary;
    static List<Integer> answer = new ArrayList<>();
    static int ans = Integer.MIN_VALUE;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        choose(0, 0);
        System.out.println(ans);
    }

    public static void choose(int currNum, int idx) {

        if(currNum == M) {
//            print();
            // 여기서 answer에 저장된 값들을 2진수로 바꾸고,
            // 순서 상관없이 진행
            ans = Math.max(ans, solve());
            return;
        }

        for(int i=idx;i<N;i++) {
            answer.add(arr[i]);
            choose(currNum + 1, i + 1);
            answer.remove(answer.size() - 1);
        }
    }

    public static int solve() {

        int result = 0;
        for(int i=1;i<answer.size();i++) {
            result = result ^ answer.get(i);
        }

        return result;
    }

    public static void print() {

        for(int i : answer) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}