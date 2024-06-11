import java.util.*;
import java.io.*;

public class Main {
    static int[][] map = new int[4][4];
    static String dir;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dir = br.readLine();
        moveMap(dir);
        printMap();
    }

    public static void moveMap(String dir) {

        if (dir.equals("L")) {
            checkLeftMap();
            for (int i = 0; i < 4; i++) {
                while (true) {
                    boolean flag = false;
                    for (int j = 3; j > 0; j--) {
                        if (map[i][j - 1] == 0 && map[i][j] != 0) {
                            int tmp = map[i][j];
                            map[i][j] = map[i][j - 1];
                            map[i][j - 1] = tmp;
                            flag = true;
                        }
                    }
                    if (!flag) break;
                }
            }
        } else if (dir.equals("R")) {
            checkRightMap();
            for (int i = 0; i < 4; i++) {
                while (true) {
                    boolean flag = false;
                    for (int j = 0; j < 3; j++) {
                        if (map[i][j + 1] == 0 && map[i][j] != 0) {
                            int tmp = map[i][j + 1];
                            map[i][j + 1] = map[i][j];
                            map[i][j] = tmp;
                            flag = true;
                        }
                    }
                    if (!flag) break;
                }
            }
        } else if (dir.equals("U")) {
            checkUpMap();
            for (int j = 0; j < 4; j++) {
                while (true) {
                    boolean flag = false;
                    for (int i = 0; i < 3; i++) {
                        if (map[i][j] == 0 && map[i + 1][j] != 0) {
                            int tmp = map[i + 1][j];
                            map[i + 1][j] = map[i][j];
                            map[i][j] = tmp;
                            flag = true;
                        }
                    }
                    if (!flag) break;
                }
            }
        } else if (dir.equals("D")) {
            checkDownMap();
            for (int j = 0; j < 4; j++) {
                while (true) {
                    boolean flag = false;
                    for (int i = 3; i > 0; i--) {
                        if (map[i][j] == 0 && map[i - 1][j] != 0) {
                            int tmp = map[i - 1][j];
                            map[i - 1][j] = map[i][j];
                            map[i][j] = tmp;
                            flag = true;
                        }
                    }
                    if (!flag) break;
                }
            }
        }
    }

    // 합쳐질 값이 있는 지 체크
    public static void checkLeftMap() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 3; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    map[i][j] *= 2;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    public static void checkRightMap() {

        for (int i = 0; i < 4; i++) {
            for (int j = 3; j > 0; j--) {
                if (map[i][j] == map[i][j - 1]) {
                    map[i][j] *= 2;
                    map[i][j - 1] = 0;
                }
            }
        }
    }

    public static void checkUpMap() {

        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 3; i++) {
                if (map[i][j] == map[i + 1][j]) {
                    map[i][j] *= 2;
                    map[i + 1][j] = 0;
                }
            }
        }
    }

    public static void checkDownMap() {

        for (int j = 0; j < 4; j++) {
            for (int i = 3; i > 0; i--) {
                if (map[i][j] == map[i - 1][j]) {
                    map[i][j] *= 2;
                    map[i - 1][j] = 0;
                }
            }
        }
    }

    public static void printMap() {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
}