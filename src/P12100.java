import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P12100 {
    static int N;
    static int answer=0;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        N = Integer.parseInt(str.nextToken());
        map = new int[N][N];
        int tmp_sum = 0;
        for(int i=0; i<N; i++) {
            String[] temp = bfr.readLine().split(" ");
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                tmp_sum=Math.max(tmp_sum, map[i][j]);
            }
        }
        dfs(0, tmp_sum);
        System.out.println(answer);

    }

    static void dfs(int cnt, int sum) {
        int[][] tempMap = new int[N][N];
        copy(tempMap, map);
        if(cnt == 5) {
//            for(int k=0; k<N; k++) {
//                for(int j=0; j<N; j++) {
//                    System.out.print(map[k][j]+" ");
//                }
//                System.out.println();
//
//            }
//            System.out.println();
            answer = Math.max(answer, sum);
            return;
        }
        for(int i=0; i<4; i++) {
            switch (i) {
                case 0 : {
                    int nx = 0;
                    int ny = 0;
                    for(int j=0; j<N; j++) {
                        nx = j;
                        ny = 0;
                        for(int z = 0; z<N; z++) {
                            if(map[j][z]==0) {
                                continue;
                            }
                            else {
                                map[nx][ny] = map[j][z];
                                if(ny!=z) {
                                    map[j][z] = 0;
                                }
                                ny++;
                            }

                        }
                    }

                    for(int j=0; j<N; j++) {
                        for (int z = 0; z < N - 1; z++) {
                            if (map[j][z] == map[j][z + 1]) {
                                map[j][z] *= 2;
                                sum = Math.max(sum, map[j][z]);
                                for (int k = z + 1; k < N - 1; k++) {
                                    map[j][k] = map[j][k + 1];
                                }
                                map[j][N - 1] = 0;
                            }
                        }
                    }
                    dfs(cnt+1, sum);
                    copy(map, tempMap);
                    break;
                }
                case 1 : {
                    int nx = 0;
                    int ny = 0;
                    for(int j=0; j<N; j++) {
                        nx = j;
                        ny = N-1;
                        for(int z = N-1; z>=0; z--) {
                            if(map[j][z]==0) {
                                continue;
                            }
                            else {
                                map[nx][ny] = map[j][z];
                                if(ny!=z) {
                                    map[j][z] = 0;
                                }
                                ny--;
                            }

                        }
                    }

                    for(int j=0; j<N; j++) {
                        for(int z = N-1; z>0; z--) {
                            if(map[j][z]==map[j][z-1]) {
                                map[j][z]*=2;
                                sum=Math.max(sum, map[j][z]);
                                for(int k = z-1; k>0; k--) {
                                    map[j][k] = map[j][k-1];
                                }
                                map[j][0]= 0;
                            }
                        }
                    }
                    dfs(cnt+1, sum);
                    copy(map, tempMap);
                    break;
                }
                case 2 : {
                    int nx = 0;
                    int ny = 0;
                    for(int z=0; z<N; z++) {
                        nx = 0;
                        ny = z;
                        for(int j = 0; j<N; j++) {
                            if(map[j][z]==0) {
                                continue;
                            }
                            else {
                                map[nx][ny] = map[j][z];
                                if(nx!=j) {
                                    map[j][z] = 0;
                                }
                                nx++;
                            }

                        }
                    }

                    for(int z=0; z<N; z++) {
                        for(int j = 0; j<N-1; j++) {
                            if(map[j][z]==map[j+1][z]) {
                                map[j][z]*=2;
                                sum=Math.max(sum, map[j][z]);
                                for(int k = j+1; k<N-1; k++) {
                                    map[k][z] = map[k+1][z];
                                }
                                map[N-1][z] = 0;
                            }
                        }
                    }
                    dfs(cnt+1, sum);
                    copy(map, tempMap);
                    break;
                }
                case 3 : {
                    int nx = 0;
                    int ny = 0;
                    for(int z=0; z<N; z++) {
                        nx = N-1;
                        ny = z;
                        for(int j = N-1; j>=0; j--) {
                            if(map[j][z]==0) {
                                continue;
                            }
                            else {
                                map[nx][ny] = map[j][z];
                                if(nx!=j) {
                                    map[j][z] = 0;
                                }
                                nx--;
                            }

                        }
                    }

                    for(int z=0; z<N; z++) {
                        for(int j = N-1; j>0; j--) {
                            if(map[j][z]==map[j-1][z]) {
                                map[j][z]*=2;
                                sum=Math.max(sum, map[j][z]);
                                for(int k = j-1; k>0; k--) {
                                    map[k][z] = map[k-1][z];
                                }
                                map[0][z] = 0;
                            }
                        }
                    }
                    dfs(cnt+1, sum);
                    copy(map, tempMap);
                    break;
                }
            }
        }
        return;
    }

    static void copy(int[][] arr, int[][] arr2) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = arr2[i][j];
            }
        }

    }
}
