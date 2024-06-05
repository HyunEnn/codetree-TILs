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
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int i = 0;

        while(true) {
            if(i >= arr.length - 1)
                break;
            int cnt = 1;
            for(int j=i+1;j<arr.length;j++) {
                if(arr[j] != arr[i]) {
                    break;
                }
                cnt++;
            }
            if(cnt >= M) {
                moveBomb(i, cnt);
                i=0;
            } else {
                i++;
            }

        }

        if(arr.length <= 0) {
            System.out.println("0");
        } else {
            System.out.println(arr.length);
            printArr();
        }
    }

    public static void moveBomb(int idx, int cnt) {

        int [] temp = new int[arr.length];
        int tempSize = 0;
        for(int i=0;i<arr.length;i++) {
            if(i >= idx && i < idx + cnt)
                continue;
            temp[tempSize] = arr[i];
            tempSize++;
        }

        arr = new int[tempSize];
        for(int i=0;i<tempSize;i++) {
            arr[i] = temp[i];
        }
    }

    public static void printArr() {

        for(int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}