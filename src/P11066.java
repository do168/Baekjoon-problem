import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11066 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        int n = Integer.parseInt(str.nextToken());
        for(int k=0; k<2; k++) {
            str = new StringTokenizer(bfr.readLine());
            int m = Integer.parseInt(str.nextToken());
            int[] ar_sum = new int[m+1];
            int[][] dp = new int[502][502];
            str = new StringTokenizer(bfr.readLine());
            for(int j=1; j<=m; j++) {
                int temp = Integer.parseInt(str.nextToken());
                ar_sum[j] += ar_sum[j-1] + temp;
            }
            for(int i = 2; i<=m; i++) {
                for (int j = i -1; j>0; j--){
                    dp[j][i] = Integer.MAX_VALUE;
                    for(int s = j; s<=i; s++) {
                        dp[j][i] = Math.min(dp[j][i], dp[j][s] + dp[s+1][i]);
                    }
                    dp[j][i] +=  ar_sum[i] - ar_sum[j-1];
                }
            }
            System.out.println(dp[1][m]);

        }
    }
}
