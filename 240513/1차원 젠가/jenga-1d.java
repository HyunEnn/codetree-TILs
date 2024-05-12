import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int tmpSize;
    static int[] arr;
    static int[] temp;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        temp = new int[N];
        for(int i=0;i<N;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        } // 1 2 3 1 1 5

        int start = 0;
        int end = 0;

        for(int i=0;i<2;i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken()) - 1; // 1
            end = Integer.parseInt(st.nextToken()) - 1; // 3
            temp = new int[N];
            tmpSize = 0;

            // temp에 arr의 start ~ end 의 값들을 넣는다.
            for(int j=0;j<N;j++) {
                if(j < start || j > end) {
                    temp[tmpSize] = arr[j];
                    tmpSize++;
                }
            }

            for(int j=0;j<tmpSize;j++) {
                arr[j] = temp[j];
            }
            N = tmpSize;
        }

        System.out.println(N);
        printMap();
    }

    public static void printMap() {

        for(int i=0;i<N;i++) {
            System.out.println(arr[i]);
        }
    }
}