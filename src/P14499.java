import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14499 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        int[] dice = {0, 0, 0, 0, 0, 0, 0};
        int[][] direc = {{}, {0,1}, {0,-1}, {-1, 0}, {1, 0}};
        int map_x = Integer.parseInt(str.nextToken());
        int map_y = Integer.parseInt(str.nextToken());
        int start_x = Integer.parseInt(str.nextToken());
        int start_y = Integer.parseInt(str.nextToken());
        int order_num = Integer.parseInt(str.nextToken());
        int[][] map = new int[map_x][map_y];
        for(int i=0; i<map_x; i++) {
            str = new StringTokenizer(bfr.readLine());
            for(int j=0; j<map_y; j++) {
                map[i][j] = Integer.parseInt(str.nextToken());
            }
        }
        int[] order = new int[order_num];
        str = new StringTokenizer(bfr.readLine());
        for(int i=0; i<order_num; i++) {
            order[i] = Integer.parseInt(str.nextToken());
        }

        ArrayList<ArrayList<Integer>> ar = new ArrayList<>();
        ArrayList<Integer> ar1 = new ArrayList<>();
        ar1.add(4);
        ar1.add(3);
        ar1.add(5);
        ar1.add(2);
        ArrayList<Integer> ar2 = new ArrayList<>();
        ar2.add(4);
        ar2.add(3);
        ar2.add(1);
        ar2.add(6);
        ArrayList<Integer> ar3 = new ArrayList<>();
        ar3.add(1);
        ar3.add(6);
        ar3.add(5);
        ar3.add(2);
        ArrayList<Integer> ar4 = new ArrayList<>();
        ar4.add(6);
        ar4.add(1);
        ar4.add(5);
        ar4.add(2);
        ArrayList<Integer> ar5 = new ArrayList<>();
        ar5.add(4);
        ar5.add(3);
        ar5.add(6);
        ar5.add(1);
        ArrayList<Integer> ar6 = new ArrayList<>();
        ar6.add(4);
        ar6.add(3);
        ar6.add(2);
        ar6.add(5);
        ar.add(ar1);
        ar.add(ar2);
        ar.add(ar3);
        ar.add(ar4);
        ar.add(ar5);
        ar.add(ar6);

        int top = 1;
        int bottom = 6;

        for(int i=0; i<order_num; i++) {
            int dir = order[i];
            int real_dir = 0;
            real_dir = dir;
            if(dir==1||dir==2) {
                real_dir = 5-dir;
            }
            start_x += direc[dir][0];
            start_y += direc[dir][1];
            if(start_x <0 || start_x>=map_x || start_y<0 || start_y>=map_y) {
                start_x -= direc[dir][0];
                start_y -= direc[dir][1];
                continue;
            }
            int next_top = ar.get(top-1).get(real_dir-1);
            int next_bottom = 7 - next_top;
            System.out.println(dice[next_top]);
            if(map[start_x][start_y]==0) {
                map[start_x][start_y] = dice[next_bottom];

            }
            else {
                dice[next_bottom] = map[start_x][start_y];
                map[start_x][start_y] = 0;
            }
            top = next_top;
            bottom = next_bottom;
            for(int j:dice) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }

    }
}
