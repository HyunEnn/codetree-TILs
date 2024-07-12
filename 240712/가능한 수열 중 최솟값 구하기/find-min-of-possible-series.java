import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static StringBuilder sb = new StringBuilder();
    static int[] ch = {4, 5, 6};
    static List<Integer> answer = new ArrayList<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        recursive(0);
    }

    public static void recursive(int idx) {

        if (idx == N) {
            if (isPossible()) {
                for(int i=0;i<answer.size();i++) {
                    System.out.print(answer.get(i));
                }
                System.exit(0);
            }
                return;
        }

        for (int i = 0; i < 3; i++) {
            answer.add(ch[i]);
            recursive(idx + 1);
            answer.remove(answer.size() - 1);
        }
    }

    // 홀짝일때를 구분해서 해야한다?
    public static boolean isPossible() {

        for(int i=0;i<answer.size();i++) {
            int idx = 0;
            while(true) {
                int start = i, end = start + idx;
                int start2 = end + 1, end2 = start2 + idx;

                if(end2 >= answer.size())
                    break;

                if(checkVal(start, end, start2, end2))
                    return false;
                idx++;
            }
        }
        return true;
    }

    public static boolean checkVal(int start, int end, int start2, int end2) {

        for(int i=0;i<=end-start;i++) {
            if(answer.get(start + i) != answer.get(start2 + i))
                return false;
        }
        return true;
    }
    // 모든 경우의 수를 위해서 순열로 모든 값을 찾아야 함.
    // ex) 4564 -> 4 5 6 4, 4/2 >= 2, 45 64, 4/3 < 2
}