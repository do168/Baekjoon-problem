import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        int N = Integer.parseInt(str.nextToken());
        int[] ar = new int[N];
        int[] dp_forward = new int[N];
        int[] dp_backward = new int[N];
        str = new StringTokenizer(bfr.readLine());
        for(int i=0; i<N; i++) {
            ar[i] = Integer.parseInt(str.nextToken());
        }
        for(int i=0; i<N; i++) {
            dp_forward[i] = 1;
            for(int j = 0; j<i; j++) {
                if(ar[j]<ar[i] && dp_forward[i]<=dp_forward[j]) {
                    dp_forward[i] = dp_forward[j]+1;
                }
            }
        }
        for(int i=N-1; i>=0; i--) {
            dp_backward[i] = 1;
            for(int j = N-1; j>i; j--) {
                if(ar[j]<ar[i] && dp_backward[i]<=dp_backward[j]) {
                    dp_backward[i] = dp_backward[j]+1;
                }
            }
        }
        for (int i = 0; i<N; i++) {
            dp_forward[i] +=dp_backward[i];
        }
        Arrays.sort(dp_forward);
        System.out.println(dp_forward[N-1]-1);
    }
}
