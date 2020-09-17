import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14890 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(str.nextToken());
        int L = Integer.parseInt(str.nextToken());

        int[][] map = new int[N][N];
        boolean[][] runway = new boolean[N][N];
        boolean[][] runway_c = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String[] temp = bfr.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int[][] tmp = new int[N][N];
        copy(tmp, map);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean flag = true;
            int first = tmp[i][0];
            int len = 1;
            for(int j=1; j<N; j++) {
                int now = tmp[i][j];
                if(Math.abs(now-first)>1){ flag = false; break;}
                if(now-first==1) {
                    if(len<L ) {
                        flag = false;
                        break;
                    }
                    if(runway[i][j-L]) {
                        flag = false;
                        break;
                    }
                    else {
                        install_roof_row(runway, i, j, L);
                        first = now;
                        len = 1;
                    }
                }
                else if(now-first==0) {
                    len++;
                }
                else if(now-first==-1) {
                    int needlen = searchFlat_row(map, i, j);
//                    if(i==2) {
//                        System.out.println("j : "+j+ " needlen : "+needlen);
//                    }
                    if(needlen>=L) {
                        install_roof_row(runway, i, j+L, L);
                        first = now;
                        len = 1;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }

            }
            if(flag) {
                answer++;
            }
        }


        for (int j = 0; j < N; j++) {
            boolean flag = true;
            int first = map[0][j];
            int len = 1;
            for(int i=1; i<N; i++) {
                int now = map[i][j];
                if(Math.abs(now-first)>1) {flag = false; break;}
                if(now-first==1) {
                    if(len<L ) {
                        flag = false;
                        break;
                    }
                    if(runway_c[i-L][j]) {
                        flag = false;
                        break;
                    }
                    else {
                        install_roof_col(runway_c, i, j, L);
                        first = now;
                        len = 1;
                    }
                }
                else if(now-first==0) {
                    len++;
                }
                else if(now-first==-1) {

                    int needlen = searchFlat_col(map, i, j);

                        if(needlen>=L) {
                        install_roof_col(runway_c, i+L, j, L);
                        first = now;
                        len = 1;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }

            }
            if(flag) {
                answer++;
            }
        }
//        for(int i=0; i<N; i++) {
//            for(int j=0; j<N; j++) {
//                System.out.print(runway[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();
        System.out.println(answer);
    }

    static int searchFlat_row(int[][] arr, int index_x, int index_y) {
        int len = 0;
        int now = arr[index_x][index_y];
        for (int j = index_y; j < N; j++) {
            if(now==arr[index_x][j])
                len++;
            else
                break;
        }
        return len;
    }

    static void install_roof_row(boolean[][] arr, int index_x, int index_y, int len) {
        for(int j= index_y-len; j<index_y; j++) {
            arr[index_x][j] = true;
        }
    }

    static int searchFlat_col(int[][] arr, int index_x, int index_y) {
        int len = 0;
        int now = arr[index_x][index_y];
        for (int i = index_x; i < N; i++) {
            if(now==arr[i][index_y])
                len++;
            else
                break;
        }
        return len;
    }

    static void install_roof_col(boolean[][] arr, int index_x, int index_y, int len) {
        for(int i= index_x-len; i<index_x; i++) {
            arr[i][index_y] = true;
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
