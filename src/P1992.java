import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1992 {
    static int N;
    static int[][] recur;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(str.nextToken());
        recur = new int[N][N];
        for(int i=0; i<N; i++) {
            str = new StringTokenizer(bfr.readLine());
            String[] temp = str.nextToken().split("");
            for(int j=0; j<N; j++) {
                recur[i][j] = Integer.parseInt(temp[j]);
            }
        }
        dfs(N, 0, N-1, 0, N-1);
        System.out.println(sb);
    }

    static void dfs(int n, int row_start, int row_end, int col_start, int col_end) {
        if(n==1) {
            sb.append(recur[row_start][col_start]);
            return;
        }
        else {
            int first = recur[row_start][col_start];
            boolean flag = false;
            for(int i=row_start; i<=row_end; i++) {
                for(int j = col_start; j<=col_end; j++) {
                    if(first!=recur[i][j]) {
                        flag = true;
                        break;
                    }
                }
                if(flag)
                    break;
            }
            if(flag) {
                sb.append("(");

                dfs(n/2, row_start, row_start+n/2-1, col_start, col_start+n/2-1);
                dfs(n/2, row_start, row_start+n/2-1, col_start+n/2, col_end);
                dfs(n/2, row_start+n/2, row_end, col_start, col_start+n/2-1);
                dfs(n/2, row_start+n/2, row_end, col_start+n/2, col_end);
                sb.append(")");
                return;
            }
            else {
                sb.append(first);
                return;
            }
        }
    }
}
