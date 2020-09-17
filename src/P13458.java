import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer str = new StringTokenizer(bfr.readLine());

        int room_num = Integer.parseInt(str.nextToken());
        int[] student = new int[room_num];
        str = new StringTokenizer(bfr.readLine());
        for(int i=0; i<room_num; i++) {
            student[i] = Integer.parseInt(str.nextToken());
        }
        str = new StringTokenizer(bfr.readLine());
        int major = Integer.parseInt(str.nextToken());
        int minor = Integer.parseInt(str.nextToken());

        long count = 0;
        for(int i=0; i<room_num; i++) {
            int student_num = student[i];
            count++;
            if(student_num-major>0) {
                count+= (student_num -major) / minor;
                if((student_num-major)%minor>0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
