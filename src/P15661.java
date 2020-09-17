import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P15661 {
    static int N;
    static int[][] skill;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());
        N = Integer.parseInt(str.nextToken());
        skill = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            str = new StringTokenizer(bfr.readLine());
            for (int j = 1; j <= N; j++) {
                skill[i][j] = Integer.parseInt(str.nextToken());
            }

        }
        ArrayList<Integer> ar1 = new ArrayList<>();
        ArrayList<Integer> ar2 = new ArrayList<>();
        ar1.add(1);
        for (int i = 2; i <= N; i++) {
            ar2.add(i);
        }
        int right_sum = 0;
        for (int i = 2; i <= N; i++) {
            for (int j = 3; j <= N; j++) {
                right_sum += skill[i][j] + skill[j][i];
            }
        }
        dfs(ar1, ar2, 1, right_sum);
        System.out.println(min);
    }

    static void dfs(ArrayList<Integer> left_team, ArrayList<Integer> right_team, int add_index, int sub) {

        int sum1 = 0;
        for(int i =0; i<left_team.size(); i++) {
            for(int j=i+1; j<left_team.size(); j++) {
                sum1+=skill[left_team.get(i)][left_team.get(j)];
                sum1+=skill[left_team.get(j)][left_team.get(i)];
            }
        }

        int sum2 = 0;
        for(int i =0; i<right_team.size(); i++) {
            for(int j=i+1; j<right_team.size(); j++) {
                sum2+=skill[right_team.get(i)][right_team.get(j)];
                sum2+=skill[right_team.get(j)][right_team.get(i)];
            }
        }
        int this_min = Math.abs(sum1-sum2);
//        if(this_min>sub) {
//            return;
////        }
        min = Math.min(min, this_min);
        for (int i = add_index + 1; i <= N; i++) {
            left_team.add(i);
            right_team.remove((Integer) i);
            dfs(left_team, right_team, i, this_min);
            left_team.remove((Integer) i);
            right_team.add(i);
        }
    }
}


