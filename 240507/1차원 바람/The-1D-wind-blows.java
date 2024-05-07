import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, Q;
    static int[][] map;
    static int[] startRow; // 시작행
    static String[] windLoc; // 바람 방향
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        startRow = new int[Q];
        windLoc = new String[Q];
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<Q;i++) {
            st = new StringTokenizer(br.readLine());
            startRow[i] = Integer.parseInt(st.nextToken());
            windLoc[i] = st.nextToken();
        }

        for(int i=0;i<Q;i++) {
            int row = startRow[i] - 1;
            String wind = windLoc[i];
            // L은 왼쪽에서 불어오는 바람, 오른쪽으로 밀어야 함
            // R은 오른쪽에서 불어오는 바람, 왼쪽으로 밀어야 함
            if(wind.equals("L")) {
                int tmp = map[row][M-1];
                for(int j=M-1;j>0;j--) {
                    map[row][j] = map[row][j-1];
                }
                map[row][0] = tmp;
            } else if(wind.equals("R")) {
                int tmp = map[row][0];
                for(int j=0;j<M-1;j++) {
                    map[row][j] = map[row][j+1];
                }
                map[row][M-1] = tmp;
            }

            boolean upFlag = false;
            boolean downFlag = false;
            boolean spreadFlag = false;
            if(row - 1 >= 0) {
                upFlag = true;
            }
            if(row + 1 < N) {
                downFlag = true;
            }
            // 여기서, 기준 행과 위아래 행에서 같은 열에 같은 값이 있다면 전파
            for(int j=0;j<M;j++) {
                 if(upFlag && downFlag) {
                     if(map[row][j] == map[row-1][j] || map[row][j] == map[row+1][j]) {
                        spreadFlag = true;
                        break;
                     }
                 }
                 else if(upFlag && !downFlag) {
                     if(map[row][j] == map[row-1][j]) {
                         spreadFlag = true;
                         break;
                     }
                 }
                 else if(!upFlag && downFlag) {
                     if(map[row][j] == map[row+1][j]) {
                         spreadFlag = true;
                         break;
                     }
                 }
            }

            if(spreadFlag) {
                // upFlag가 true면 위로 진행하고, downFlag가 true면 이래로 진행
                if(upFlag)
                    spreadRotate(row - 1, wind, "up");
                if(downFlag)
                    spreadRotate(row + 1, wind, "down");
            }
        }

        printMap();
    }

    public static void spreadRotate(int startRow, String wind, String dir) {

        // 여기서 전파된 곳을 기준으로 한 칸씩 진행하는데 wind의 반대 방향으로
        if(wind.equals("L")) {
           // L이였으니까, 여기서는 반대방향인 왼쪽으로 밀어야 함
           int tmp = map[startRow][0];
           for(int i=0;i<M-1;i++) {
               map[startRow][i] = map[startRow][i+1];
           }
           map[startRow][M-1] = tmp;
           wind = "R";
        }
        else if(wind.equals("R")) {

            int tmp = map[startRow][M-1];
            for(int i=M-1;i>0;i--) {
                map[startRow][i] = map[startRow][i-1];
            }
            map[startRow][0] = tmp;
            wind = "L";
        }

        // 다 밀고, 방향대로 또 체크한번 해줘야 함
        if(dir.equals("up") && (startRow - 1) >= 0) {
            for(int i=0;i<M;i++) {
                if(map[startRow][i] == map[startRow - 1][i]) {
                    spreadRotate(startRow - 1, wind, dir);
                }
            }
        } else if(dir.equals("down") && (startRow + 1) < N) {
            for(int i=0;i<M;i++) {
                if(map[startRow][i] == map[startRow + 1][i]) {
                    spreadRotate(startRow + 1, wind , dir);
                }
            }
        }
    }

    public static void printMap() {

        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 1. 바람이 불어서 3번째 행이 오른쪽으로 한 칸씩 밀림
 * 2. 그러면 위 아래인 2, 4행이 3행과 같은 열에서 일치하는 숫자가 하나 이상 존재하면 전파 진행
 * 3. 전파 진행은 바람이 불어서 민 방향의 반대 방향으로 진행
 * 4. 이제 2행은 1행과의 같은 열에서 비교하고, 있으면 또 반대 방향으로 밀기
 * 5. 없으면 위쪽 전파는 종료하고, 아래의 4행에서 5행과의 같은 열의 숫자가 있는 지 비교
 * 6. 있으면, 반대 방향으로 전파하고, 없으면 종료
 */