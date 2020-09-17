import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15683 {
    static int N;
    static int M;
    static ArrayList<Node15683> ar;
    static int[] dir_x = {-1, 1, 0, 0};
    static int[] dir_y = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());
        int[][] room = new int[N][M];
        ar = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String[] temp = bfr.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(temp[j]);
                if (room[i][j] != 0) {
                    ar.add(new Node15683(i, j, room[i][j]));
                }
            }
        }

    }

    static void dfs(int[][] map, int num, int index) {
        int[][] tmp = new int[N][M];
        copy(tmp, map);
        if (num == ar.size()) {

            return;
        }
        Node15683 n = ar.get(index);
        switch (n.num) {
            case(1) : {

                for (int i = 0; i < 4; i++) {
                    int x = n.x + dir_x[i];
                    int y = n.y + dir_y[i];

                    while (true) {
                        if (x < 0 || y < 0 || x >= N || y >= N) {
                            x -= dir_x[i];
                            y -= dir_y[i];
                            break;
                        }
                        if (tmp[x][y] == 6) {
                            x -= dir_x[i];
                            y -= dir_y[i];
                        }
                        tmp[x][y] = 7;
                        x += dir_x[i];
                        y += dir_y[i];
                    }
                    dfs(tmp, num+1, index+1);
                    copy(tmp, map);
                }

                break;
            }
            case(2) : {
                for(int i=0; i<2; i++) {
                    for(int j=2*i; j<2*i+2; j++) {
                        int x = n.x + dir_x[i];
                        int y = n.y + dir_y[i];

                        while (true) {
                            if (x < 0 || y < 0 || x >= N || y >= N) {
                                x -= dir_x[i];
                                y -= dir_y[i];
                                break;
                            }
                            if (tmp[x][y] == 6) {
                                x -= dir_x[i];
                                y -= dir_y[i];
                            }
                            tmp[x][y] = 7;
                            x += dir_x[i];
                            y += dir_y[i];
                        }
                    }
                    dfs(tmp, num+1, index+1);
                    copy(tmp, map);
                }
                break;
            }

            case(3) : {
                for(int i=0; i<2; i++) {
                    for(int j=0; j<2; j++) {
                        int x = n.x+dir_x[i];
                        int y = n.y;
                        while (true) {
                            if (x < 0 || y < 0 || x >= N || y >= N) {
                                x -= dir_x[i];
                                y -= dir_y[i];
                                break;
                            }
                            if (tmp[x][y] == 6) {
                                x -= dir_x[i];
                                y -= dir_y[i];
                            }
                            tmp[x][y] = 7;
                            x += dir_x[i];
                            y += dir_y[i];
                        }
                        x = n.x;
                        y = n.y+dir_y[4-i+j];
                        while (true) {
                            if (x < 0 || y < 0 || x >= N || y >= N) {
                                x -= dir_x[i];
                                y -= dir_y[i];
                                break;
                            }
                            if (tmp[x][y] == 6) {
                                x -= dir_x[i];
                                y -= dir_y[i];
                            }
                            tmp[x][y] = 7;
                            x += dir_x[i];
                            y += dir_y[i];
                        }
                        dfs(tmp, num+1, index+1);
                        copy(tmp, map);
                    }
                }
                break;
            }
            case(4) : {
                for(int i=0; i<2; i++) {
                    
                }
            }
        }


    }


    static void copy(int[][] arr, int[][] arr2) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = arr2[i][j];
            }
        }

    }
}

class Node15683 {
    int x;
    int y;
    int num;

    Node15683(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}

