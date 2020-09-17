import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        String order;
        int num = 0;
        int[] exist = new int[21];
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(str.nextToken());

        for(int i =0; i<M; i++) {
            str = new StringTokenizer(bfr.readLine());
            order = str.nextToken();
            if(str.hasMoreTokens())
                num = Integer.parseInt(str.nextToken());
            switch (order) {
                case "add" : { exist[num] = 1; break;}
                case "remove" : { exist[num] = 0; break;}
                case "check" : { sb.append(exist[num]+"\n"); break;}
                case "toggle" : { exist[num] = exist[num]>0 ? 0 : 1; break;}
                case "all" : { Arrays.fill(exist, 1); break;}
                case "empty" : { Arrays.fill(exist, 0); break;}
            }
        }
        System.out.println(sb);
    }
}
