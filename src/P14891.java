import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P14891 {
    public static void main(String[] args) throws IOException {
        int[][] gear = new int[5][9];
        int[] gear_rot_dir = new int[5];
        Arrays.fill(gear_rot_dir, 0);
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str;
        for (int i = 1; i <= 4; i++) {
            str = new StringTokenizer(bfr.readLine());
            String[] num = str.nextToken().split("");
            for (int j = 1; j <= 8; j++) {
                gear[i][j] = Integer.parseInt(num[j - 1]);
            }
        }

        str = new StringTokenizer(bfr.readLine());
        int rotate_num = Integer.parseInt(str.nextToken());
        for (int i = 0; i < rotate_num; i++) {
            str = new StringTokenizer(bfr.readLine());
            int rot_gear = Integer.parseInt(str.nextToken());
            int rot_dir = Integer.parseInt(str.nextToken());
            gear_rot_dir[rot_gear] = rot_dir;
            int left_gear = (rot_gear == 1) ? 0 : rot_gear - 1;
            int right_gear = (rot_gear == 4) ? 0 : rot_gear + 1;
            int vir_rot_gear = rot_gear;
            int vir_rot_dir = rot_dir;

            while (left_gear != 0) {
                if (gear[vir_rot_gear][7] != gear[left_gear][3]) {
                    gear_rot_dir[left_gear] = -1 * vir_rot_dir;
                    vir_rot_gear = left_gear;
                    vir_rot_dir = gear_rot_dir[left_gear];
                    left_gear = (vir_rot_gear == 1) ? 0 : vir_rot_gear - 1;
                } else {
                    break;

                }
            }
            vir_rot_gear = rot_gear;
            vir_rot_dir = rot_dir;
            while (right_gear != 0) {
                if (gear[vir_rot_gear][3] != gear[right_gear][7]) {
                    gear_rot_dir[right_gear] = -1 * vir_rot_dir;
                    vir_rot_gear = right_gear;
                    vir_rot_dir = gear_rot_dir[right_gear];
                    right_gear = (vir_rot_gear == 4) ? 0 : vir_rot_gear + 1;
                } else {
                    break;
                }

            }
            for (int j = 1; j <= 4; j++) {

                int tmp = 0;
                if (gear_rot_dir[j] == 1) {
                    tmp = gear[j][8];
                    for (int z = 8; z >= 2; z--) {
                        gear[j][z] = gear[j][z - 1];
                    }
                    gear[j][1] = tmp;

                } else if (gear_rot_dir[j] == -1) {
                    tmp = gear[j][1];
                    for (int z = 1; z <= 7; z++) {
                        gear[j][z] = gear[j][z + 1];
                    }
                    gear[j][8] = tmp;
                }
                gear_rot_dir[j] = 0;
            }
        }
        int answer = 0;
        for (int i = 1; i <= 4; i++) {
            if (gear[i][1] == 1) {
                answer += Math.pow(2, i-1);
            }
        }
        System.out.println(answer);
    }
}
