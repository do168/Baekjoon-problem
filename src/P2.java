import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2 {

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] row = bfr.readLine().split(" ");
        String[] A = new String[row.length-1];
        int A_valid = Integer.parseInt(row[0].substring(0, 1));
        for(int i =1; i<row.length; i++) {
            A[i-1] = row[i];
        }
        sb.append("0; ");
        int next_index = A_valid;
        int count = 0;
        while(true) {
            int index = Integer.parseInt(A[next_index]);
            if(index == 0 ) {
                sb.append(index+" ");
                count++;
                sb.append((count+1)+" ");
                count++;
                if(count==8) {
                    break;
                }
                next_index = Integer.parseInt(A[next_index+1]);
            }
            else {
                sb.append(index+" ");
                sb.append(A[next_index+1]+" ");
                count+=2;
                if(count==8) {
                    break;
                }
                break;
            }
        }
        while(count<8) {
            sb.append("0 ");
            count++;
        }
        System.out.println(sb.toString());


    }
}
