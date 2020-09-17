import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {
    static int a;
    static int b;
    static boolean[] visit;
    static Queue<Integer> q;
    static String[] order;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        int T = Integer.parseInt(str.nextToken());
        for(int test = 0; test<T; test++) {
            q = new LinkedList<>();
            visit = new boolean[10000];
            order = new String[10000];
            Arrays.fill(order, "");
            str = new StringTokenizer(bfr.readLine());
            a = Integer.parseInt(str.nextToken());
            b = Integer.parseInt(str.nextToken());
            q.add(a);
            visit[a]  =true;
            while(!q.isEmpty() && !visit[b]) {
                int cur = q.poll();
                int D = (2*cur) % 10000;
                int S = cur==0 ? 9999 : cur-1;
                int L = left_shift(cur);
                int R = right_shift(cur);
                if(!visit[D]) {
                    q.add(D);
                    visit[D] = true;
                    order[D] = order[cur] + "D";
                }
                if(!visit[S]) {
                    q.add(S);
                    visit[S] = true;
                    order[S] = order[cur] + "S";
                }
                if(!visit[L]) {
                    q.add(L);
                    visit[L] = true;
                    order[L] = order[cur] + "L";
                }
                if(!visit[R]) {
                    q.add(R);
                    visit[R] = true;
                    order[R] = order[cur] + "R";
                }
            }
            System.out.println(order[b]);
        }
    }



    static int left_shift(int num) {
        return (num % 1000) * 10 + num/1000;
    }
    static int right_shift(int num) {
        return (num % 10) * 1000 + num/10;
    }
}
