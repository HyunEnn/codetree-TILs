import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int i = 0;

        while (true) {
            if (checkBomb()) {
                while (true) {
                    if (i >= arr.length)
                        break;
                    int cnt = 1;
                    if(i != arr.length - 1) {
                        for (int j = i + 1; j < arr.length; j++) {
                            if (arr[j] != arr[i]) {
                                break;
                            }
                            cnt++;
                        }
                    }
                    if (cnt >= M) {
                        changeBomb(i, cnt); // 여기서 터질 값들을 전부 -1로 변경
                        i++;
                    } else {
                        i++;
                    }
                }
                moveBomb();
                i=0;
            }
            else
                break;
        }

        if (arr.length <= 0) {
            System.out.println("0");
        } else {
            System.out.println(arr.length);
            printArr();
        }
    }

    public static boolean checkBomb() {

        for (int i = 0; i < arr.length; i++) {
            int cnt = 1;
            if(i != arr.length - 1) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] != arr[j]) {
                        break;
                    }
                    cnt++;
                }
            }
            if (cnt >= M)
                return true;
        }
        return false;
    }

    public static void changeBomb(int idx, int cnt) {

        for (int i = idx; i < idx + cnt; i++) {
            arr[i] = -1;
        }
    }

    public static void moveBomb() {

        int[] temp = new int[arr.length];
        int tempSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == -1)
                continue;
            temp[tempSize] = arr[i];
            tempSize++;
        }

        arr = new int[tempSize];
        for (int i = 0; i < tempSize; i++) {
            arr[i] = temp[i];
        }
    }

    public static void printArr() {

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}