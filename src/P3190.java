import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3190 {
    static int N;
    static int[][] map;
    static boolean[][] isBody;
    static int[][] dir = {{1,0}, {0, -1}, {-1, 0},{0, 1}};
    static int[][] map_dir;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(str.nextToken());
        map = new int[N+1][N+1];
        isBody = new boolean[N+1][N+1];
        map_dir = new int[N+1][N+1];

        str = new StringTokenizer(bfr.readLine());
        int K = Integer.parseInt(str.nextToken());
        for(int i=0; i<K; i++) {
            str= new StringTokenizer(bfr.readLine());
            int x = Integer.parseInt(str.nextToken());
            int y = Integer.parseInt(str.nextToken());
            map[x][y] = 1;
        }
        str= new StringTokenizer(bfr.readLine());
        int L = Integer.parseInt(str.nextToken());
        int now_time = 0;
        int now_dir = 3;
        int now_x = 1;
        int now_y = 1;
        int tail_x = 1;
        int tail_y = 1;
        isBody[1][1] = true;
        boolean flag = false;
        for(int i=0; i<L; i++) {
            str= new StringTokenizer(bfr.readLine());
            int time = Integer.parseInt(str.nextToken());
            while(now_time<time) {
//                System.out.println(now_time+" "+now_x+" "+now_y);
                now_time++;
                map_dir[now_x][now_y] = now_dir;
                now_x+=dir[now_dir][0];
                now_y+=dir[now_dir][1];

                if(now_x<1||now_x>N || now_y<1 || now_y>N) {
                    System.out.println(now_time);
                    flag = true;
                    return;
                }
                if(isBody[now_x][now_y]==true) {
                    System.out.println(now_time);
                    flag = true;
                    return;
                }

                isBody[now_x][now_y] = true;

                if(map[now_x][now_y]==0) {isBody[tail_x][tail_y]=false; int tmp = tail_x; tail_x +=dir[map_dir[tail_x][tail_y]][0];
                tail_y+=dir[map_dir[tmp][tail_y]][1];}
                else {
                    map[now_x][now_y]=0;
                }
            }
            String order = str.nextToken();
            if(order.equals("L")) {
                now_dir-=1;
                if(now_dir==-1) now_dir=3;
            }
            else {
                now_dir+=1;
                if(now_dir==4) now_dir = 0;
            }
        }
//        for(int i = 1; i<=N; i++) {
//            for(int j=1; j<=N; j++) {
//                System.out.print(isBody[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        if(!flag) {
            while(true){
                now_time++;
                map_dir[now_x][now_y] = now_dir;
                now_x+=dir[now_dir][0];
                now_y+=dir[now_dir][1];
                if(now_x<1||now_x>N || now_y<1 || now_y>N) {
                    System.out.println(now_time);
                    flag = true;

                    System.out.println();
                    return;
                }
                if(isBody[now_x][now_y]==true) {
                    System.out.println(now_time);
                    flag = true;
                    return;
                }

                isBody[now_x][now_y] = true;
                if(map[now_x][now_y]==0) {isBody[tail_x][tail_y]=false; int tmp = tail_x; tail_x +=dir[map_dir[tail_x][tail_y]][0];
                    tail_y+=dir[map_dir[tmp][tail_y]][1];}
                else {
                    map[now_x][now_y]=0;
                }
            }
        }

    }
}
