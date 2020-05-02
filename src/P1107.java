import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        ArrayList<Integer> al = new ArrayList<>();
        int count = 0;
        for(int i=0; i<10; i++) {
            al.add(i);
        }
        String N = str.nextToken();
        int N_to_int = Integer.parseInt(N);
        str = new StringTokenizer(bfr.readLine());
        int M = Integer.parseInt(str.nextToken());
        if(M!=0)
            str = new StringTokenizer(bfr.readLine());
        for(int i=0; i<M; i++) {
            int tmp = Integer.parseInt(str.nextToken());
            al.remove((Integer)tmp);
        }
        StringBuilder sb = new StringBuilder();
        String[] N_ = N.split("");
        if(M!=10) {
            for (int i = 0; i < N_.length; i++) {
                int temp = Integer.parseInt(N_[i]);
                int tmp_a = 500000;
                int tmp_b = 500000;
                for (int j = temp; j >= 0; j--) {
                    if (al.contains(j)) {
                        tmp_a = j;
                        break;
                    }
                }
                for (int j = temp; j <= 9; j++) {
                    if (al.contains(j)) {
                        tmp_b = j;
                        break;
                    }
                }
                int min = Math.abs(temp - tmp_a) > Math.abs(temp - tmp_b) ? tmp_b : tmp_a;
                sb.append(min);
            }
        }
        else {
            sb.append(Integer.MAX_VALUE-500000);
        }
        System.out.println(sb);
        int i = N_to_int - Integer.parseInt(sb.toString());
        if(Math.abs(N_to_int-100) <= Math.abs(i) + N_.length) {
            count = Math.abs(N_to_int-100);
        }
        else {
            count = N_.length + Math.abs(i);
        }
        System.out.println(count);

    }
}
