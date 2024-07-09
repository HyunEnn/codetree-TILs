import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static List<Integer> answer = new ArrayList<>();
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        choose(0);

    }

    public static void print() {

        for(int i=0;i<answer.size();i++) {
            System.out.print(answer.get(i) + " ");
        }
        System.out.println();
    }

    public static void choose(int currNum) {

        if(currNum == N) {
            print();
            return;
        }

        for(int i=1;i<=K;i++) {
            if(answer.size() < 2) {
                answer.add(i);
                choose(currNum + 1);
                answer.remove(answer.size() - 1);
            }
            // 2인데, 2가 왔으면 2 % K + 1을 하면? 1, 1 % 2 + 1을 하면 2
            // 4인데, 4가 왔으면 4 % K + 1을 하면? 1

            else {
                if(!(i == answer.get(answer.size() - 1) && i == answer.get(answer.size() - 2))) {
                    // size() - 1 와 size() - 2의 값이 같으면, 현재 값 말고 다음 값을 넣어줘야함
                    answer.add(i);
                    choose(currNum + 1);
                    answer.remove(answer.size() - 1);
                }
            }
        }
    }
}