import java.io.*;
import java.util.*;

public class Main {
    static long A, B, C;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        A = Long.parseLong(input[0]);
        B = Long.parseLong(input[1]);
        C = Long.parseLong(input[2]);

        System.out.println(pow(A, B));
    }

    static long pow(long a, long b) {
        if (b == 1) return a % C;

        long temp = pow(a, b / 2);

        if (b % 2 == 0) {
            return (temp * temp) % C;
        } else {
            return (temp * temp % C) * a % C;
        }
    }
}