import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14500 {
    static int[][] map;
    static boolean[][] isVisit;
    static boolean[][] isChecked;
    static int answer = Integer.MIN_VALUE;
    static int[] dir_x = {-1,1,0,0};
    static int[] dir_y = {0, 0, -1, 1};
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(str.nextToken());
        M = Integer.parseInt(str.nextToken());

        map = new int[N][M];
        isChecked = new boolean[N][M];
        isVisit = new boolean[N][M];
        for(int i=0; i<N; i++) {
//            str = new StringTokenizer(bfr.readLine());
            String[] temp = bfr.readLine().split(" ");

            for(int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                isVisit[i][j] = true;
                dfs(i, j, 1, map[i][j], 0);
                isVisit[i][j] = false;
                isChecked[i][j]=true;
            }

        }
        System.out.println(answer);
    }

    static void dfs(int x, int y, int num, int sum, int two_sum) {
        int new_sum = sum;
        if(num==4) {
            answer = Math.max(answer, sum);
            answer = Math.max(answer, two_sum);
            return;
        }
        if(num==2) {
            int[] temp = new int[4];
            for(int i=0; i<4; i++) {
                int n_x = x+dir_x[i];
                int n_y = y+dir_y[i];
                if(n_x<0 || n_x>=N || n_y<0 || n_y>=M) {
                    continue;
                }
                if(isVisit[n_x][n_y]) {
                    continue;
                }
                temp[i] = map[n_x][n_y];
            }
            int mymax = 0;
            for(int j=0; j<4; j++) {
                for(int z = j+1; z<4; z++) {
                    mymax = Math.max(mymax, temp[j]+temp[z]);
                }
            }
            two_sum = new_sum+mymax;
        }

        for(int i=0; i<4; i++) {
            int n_x = x+dir_x[i];
            int n_y = y+dir_y[i];


            if(n_x<0 || n_x>=N || n_y<0 || n_y>=M) {
                continue;
            }
            if(isVisit[n_x][n_y]) {
                continue;
            }

            isVisit[n_x][n_y] = true;
            dfs(n_x, n_y, num+1, sum+map[n_x][n_y], two_sum);
            isVisit[n_x][n_y] = false;
        }

    }
}
