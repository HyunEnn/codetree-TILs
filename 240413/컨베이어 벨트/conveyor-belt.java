import java.io.*;
import java.util.*;

public class Main {
    static int N, T; // N : 개수, T : 시간 초
    static int[][] map;
    static StringTokenizer st;
    static int time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        time = 0;
        map = new int[2][N];
        for(int i=0;i<2;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(time != T) {
            int temp = 0;
            for(int i=0;i<2;i++) {
                if(i == 0) {
                    for(int j=0;j<N;j++) { // ex) 2면 0, 1만 진행
                        // 초기 값일때, temp를 설정하고 시작해야함
                        if(j == 0) {
                            temp = map[i][j+1];
                            map[i][j+1] = map[i][j];
                        }
                        // 마지막 열일 경우, 아래로 밀고 시간 초 증가
                        else if(j == N-1) {
                            int tmp = map[i+1][j-N+1];
                            map[i+1][j-N+1] = temp;
                            temp = tmp;
                        }
                        else { // 예외 상황 아니면, temp 값을 현재 값에
                            int tmp = map[i][j+1];
                            map[i][j+1] = temp;
                            temp = tmp;
                        }
                    }
                }
                else {
                    for(int j=0;j<N;j++) {
                        // 좌측 끝에 도달했으므로, 위에 값과 변경
                        if(j == N-1) {
                            map[i-1][j-N+1] = temp;
                        }
                        else {
                            int tmp = map[i][j+1];
                            map[i][j+1] = temp;
                            temp = tmp;
                        }
                    }
                }
            }
            time++;
        }

        for(int i=0;i<2;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}